package exam.animals.model;

public class Animal {

	private String date;
	private String color;
	private String breed;
	private String sex;
	private String state;
	private String name;
	private String dateCreated;

	public Animal(String date, String color, String breed, String sex, String state, String name, String dateCreated) {
		this.date = date;
		this.color = color;
		this.breed = breed;
		this.sex = sex;
		this.state = state;
		this.name = name;
		this.dateCreated = dateCreated;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

}
