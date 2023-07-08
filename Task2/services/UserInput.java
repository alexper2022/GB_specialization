package Task2.services;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UserInput {
	public static Scanner userIn() {
		return new Scanner(System.in, StandardCharsets.UTF_8);
	}
}
