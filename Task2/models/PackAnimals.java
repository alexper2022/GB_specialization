package Task2.models;

import java.sql.*;

public class PackAnimals extends Animals {
	public PackAnimals(String name, String birthday, String comands, int gender) {
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
	public Animals getAnymals() {
		return null;
	}

	@Override
	public String toString() {
		return "Вьючные животные: " + super.toString();
	}
}
