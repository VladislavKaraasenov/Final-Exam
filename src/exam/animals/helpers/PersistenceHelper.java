package exam.animals.helpers;

import exam.animals.exceptions.*;
import exam.animals.model.*;

import java.util.*;
import java.io.*;

public class PersistenceHelper {

	private static final String SEPARATOR = ",";

	public static void save(File file, List<Animal> animalsList) throws PersistenceHelperSavingException {
		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {

			for (Animal animal : animalsList) {
				String animalString = createString(animal);
				writer.println(animalString);
			}
		} catch (IOException e) {
			throw new PersistenceHelperSavingException();
		}
	}

	public static List<Animal> load(File file) throws PersistenceHelperLoadingException {
		List<Animal> animalsList = new ArrayList<>();
		try (Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream(file)))) {

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				Animal animal = createAnimal(line);
				animalsList.add(animal);
			}
		} catch (FileNotFoundException e) {
			throw new PersistenceHelperLoadingException();
		}
		return animalsList;
	}

	private static String createString(Animal animal) {
		StringBuilder builder = new StringBuilder();
		builder.append(animal.getDate());
		builder.append(SEPARATOR);
		builder.append(animal.getColor());
		builder.append(SEPARATOR);
		builder.append(animal.getBreed());
		builder.append(SEPARATOR);
		builder.append(animal.getSex());
		builder.append(SEPARATOR);
		builder.append(animal.getState());
		builder.append(SEPARATOR);
		builder.append(animal.getName());
		builder.append(SEPARATOR);
		builder.append(animal.getDateCreated());

		return builder.toString();
	}

	private static Animal createAnimal(String line) {
		String[] elements = line.split(SEPARATOR);

		return new Animal(elements[0], elements[1], elements[2], elements[3], elements[4], elements[5], elements[6]);
	}

}
