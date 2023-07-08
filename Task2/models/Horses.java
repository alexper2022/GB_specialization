package Task2.models;

public class Horses extends PackAnimals {
	public Horses(String name, String birthday, String comands, int gender) {
		super(name, birthday, comands, gender);
	}

	@Override
	public String getName() {
		return super.getName();
	}


	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public String getComands() {
		return super.getComands();
	}

	@Override
	public void setComands(String comands) {
		super.setComands(comands);
	}

	@Override
	public String getBirthday() {
		return super.getBirthday();
	}

	@Override
	public void setBirthday(String birthday) {
		super.setBirthday(birthday);
	}

	@Override
	public int getGender() {
		return super.getGender();
	}

	@Override
	public void setGender(char gender) {
		super.setGender(gender);
	}

	@Override
	public String toString() {
		return "Лошадь: " + super.toString();
	}
}
