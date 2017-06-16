package exam.animals.controller;

import exam.animals.exceptions.*;
import exam.animals.helpers.*;
import exam.animals.model.*;

import java.io.File;
import java.util.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class AnimalFrame extends JFrame {

	private AnimalTableModel tableModel;
	private JTable table;
	private JFileChooser fileChooser;
	private JScrollPane scrollPane;
	private List<Animal> animals;

	public AnimalFrame() {
		super();

		animals = new ArrayList<>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setBounds(50, 50, 1000, 600);

		createView();
	}

	public void createView() {
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 20, 950, 450);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		tableModel = new AnimalTableModel();
		tableModel.setAnimalsList(animals);
		table.setModel(tableModel);

		JButton loadButton = new JButton("Load");
		loadButton.setBounds(840, 500, 100, 30);
		loadButton.addActionListener(load -> loadFile());
		add(loadButton);

		JButton saveButton = new JButton("Save");
		saveButton.setBounds(720, 500, 100, 30);
		saveButton.addActionListener(save -> saveFile());
		add(saveButton);

		JButton removeButton = new JButton("Delete");
		removeButton.setBounds(600, 500, 100, 30);
		removeButton.addActionListener(remove -> removeLine());
		add(removeButton);

	}

	private void loadFile() {
		fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			
			try {
				File file = fileChooser.getSelectedFile();
				animals = PersistenceHelper.load(file);
				tableModel.setAnimalsList(animals);
				tableModel.fireTableDataChanged();
			} catch (PersistenceHelperLoadingException e) {
				e.printStackTrace();
			}
		}
	}

	private void saveFile() {
		fileChooser = new JFileChooser();
		int result = fileChooser.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {

			try {
				File file = fileChooser.getSelectedFile();
				PersistenceHelper.save(file, animals);
			} catch (PersistenceHelperSavingException e) {
				e.printStackTrace();
			}
		}
	}

	private void removeLine() {
		int rowIndex = table.getSelectionModel().getLeadSelectionIndex();
		if (rowIndex >= 0) {
			animals.remove(rowIndex);
			tableModel.setAnimalsList(animals);
			tableModel.fireTableDataChanged();
		}
	}

}
