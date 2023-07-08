package Task2.models;

import static Task2.sql.InteractionSql.writeCounterInDB;


public class Counter implements AutoCloseable {

	private static int counter;

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int newCounter) {
		counter = newCounter;
	}

	public static void add() throws ClassNotFoundException {
		++counter;
		writeCounterInDB(counter);

	}

	public static void del() throws ClassNotFoundException {
		--counter;
		writeCounterInDB(counter);
	}

	@Override
	public void close() {
		System.out.println("Счетчик закрыт!");
	}
}
