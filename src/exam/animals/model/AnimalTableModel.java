package exam.animals.model;

import java.util.*;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class AnimalTableModel extends AbstractTableModel {

	private List<Animal> animalsList;

	@Override
	public int getRowCount() {
		return animalsList.size();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Animal animal = animalsList.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			return animal.getDate();
		case 1:
			return animal.getColor();
		case 2:
			return animal.getBreed();
		case 3:
			return animal.getSex();
		case 4:
			return animal.getState();
		case 5:
			return animal.getName();
		case 6:
			return animal.getDateCreated();

		}
		return null;
	}

	public List<Animal> getAnimalsList() {
		return this.animalsList;
	}

	public void setAnimalsList(List<Animal> animalsList) {
		this.animalsList = animalsList;
	}

	private String[] columns = { "Date", "Color", "Breed", "Sex", "State", "Name", "Date created" };

	@Override
	public String getColumnName(int index) {
		return columns[index];
	}

}
