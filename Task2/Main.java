package Task2;

import static Task2.sql.InteractionSql.readCounterInDB;
import static Task2.ui.Ui.runApp;

public class Main {
	public static void main(String[] args) throws Exception {
		readCounterInDB();
		runApp();
	}
}
