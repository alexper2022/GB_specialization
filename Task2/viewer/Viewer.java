package Task2.viewer;

import java.util.List;


public class Viewer {
	public static <T> void viewAllAnimals(List<T> objects) {
		for (T obj : objects) {
			System.out.println(obj.toString());
		}
	}
}
