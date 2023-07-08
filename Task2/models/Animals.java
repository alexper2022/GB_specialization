package Task2.models;


public abstract class Animals {
	private int id;
	private String name;
	private String comands;
	private String birthday;
	private int gender;

	public Animals(String name, String birthday, String comands, int gender) {
		this.name = name;
		this.birthday = birthday;
		this.comands = comands;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComands() {
		return comands;
	}

	public void setComands(String comands) {
		this.comands = comands;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public abstract Animals getAnymals();

	@Override
	public String toString() {
		return "Имя: " + name + ", " +
				", comands='" + comands + ", " +
				", Команды: " + birthday +
				", пол: " + comands + ".";
	}
}
