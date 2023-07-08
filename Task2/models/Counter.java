package Task2.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static Task2.sql.InteractionSql.writCounterInDB;

public class Counter implements AutoCloseable{

	private static int counter;

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int newCounter) {
		counter = newCounter;
	}

	public static void add() throws ClassNotFoundException {
		++counter;
		writCounterInDB(counter);

	}
	public static void del() throws ClassNotFoundException {
		--counter;
		writCounterInDB(counter);
	}

	@Override
	public void close() {
		System.out.println("Счетчик закрыт!");
	}
}
