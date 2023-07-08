package Task2.models;

public class Pets extends Animals {
	public Pets(String name, String birthday, String comands, int gender) {
		super(name, birthday, comands, gender);
	}

	@Override
	public String toString() {
		return "Pets{}";
	}

	@Override
	public Animals getAnymals() {
		return null;
	}
}
