package Task2.sql;

import Task2.models.*;

import java.sql.*;


public class InteractionSql {

	// Константа, в которой хранится адрес подключения

	public static void viewCats() throws Exception {
		try {
			ResultSet resultSet;
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:animals.db");
			Statement statement = connection.createStatement();
			System.out.println("\n-= Кошки =-");
			// В resultSet будет храниться результат запроса командой statement.executeQuery()
			resultSet = statement.executeQuery("SELECT * FROM cats");
			// Проходимся по нашему resultSet и выводим на экран
			while (resultSet.next()) {
				System.out.printf("№ %d - Имя: %s, д/р: %s, Пол: %s, Понимает команды: %s \n", resultSet.getInt("Id"), resultSet.getString("Name"), resultSet.getString("Birthday"), resultSet.getString("Gender"), resultSet.getString("Commands"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void viewDogs() throws Exception {
		try {
			ResultSet resultSet;
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:animals.db");
			Statement statement = connection.createStatement();
			System.out.println("\n-= Собаки =-");
			resultSet = statement.executeQuery("SELECT * FROM dogs");
			// Проходимся по нашему resultSet и выводим на экран
			while (resultSet.next()) {
				System.out.printf("№ %d - Имя: %s, д/р: %s, Пол: %s, Понимает команды: %s \n", resultSet.getInt("Id"), resultSet.getString("Name"), resultSet.getString("Birthday"), resultSet.getString("Gender"), resultSet.getString("Commands"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void viewHamsters() throws Exception {
		try {
			ResultSet resultSet;
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:animals.db");
			Statement statement = connection.createStatement();
			System.out.println("\n-= Хомяки =-");
			resultSet = statement.executeQuery("SELECT * FROM hamsters");
			// Проходимся по нашему resultSet и выводим на экран
			while (resultSet.next()) {
				System.out.printf("№ %d - Имя: %s, д/р: %s, Пол: %s, Понимает команды: %s \n", resultSet.getInt("Id"), resultSet.getString("Name"), resultSet.getString("Birthday"), resultSet.getString("Gender"), resultSet.getString("Commands"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void viewHorses() throws Exception {
		try {
			ResultSet resultSet;
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:animals.db");
			Statement statement = connection.createStatement();
			System.out.println("\n-= Лошади =-");
			resultSet = statement.executeQuery("SELECT * FROM horses");
			// Проходимся по нашему resultSet и выводим на экран
			while (resultSet.next()) {
				System.out.printf("№ %d - Имя: %s, д/р: %s, Пол: %s, Понимает команды: %s \n", resultSet.getInt("Id"), resultSet.getString("Name"), resultSet.getString("Birthday"), resultSet.getString("Gender"), resultSet.getString("Commands"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void viewDonkeys() throws Exception {
		try {
			ResultSet resultSet;
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:animals.db");
			Statement statement = connection.createStatement();
			System.out.println("\n-= Ослы =-");
			resultSet = statement.executeQuery("SELECT * FROM donkeys");
			// Проходимся по нашему resultSet и выводим на экран
			while (resultSet.next()) {
				System.out.printf("№ %d - Имя: %s, д/р: %s, Пол: %s, Понимает команды: %s \n", resultSet.getInt("Id"), resultSet.getString("Name"), resultSet.getString("Birthday"), resultSet.getString("Gender"), resultSet.getString("Commands"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void viewCamels() throws Exception {
		try {
			ResultSet resultSet;
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:animals.db");
			Statement statement = connection.createStatement();
			System.out.println("\n-= Верблюды =-");
			resultSet = statement.executeQuery("SELECT * FROM camels");
			// Проходимся по нашему resultSet и выводим на экран
			while (resultSet.next()) {
				System.out.printf("№ %d - Имя: %s, д/р: %s, Пол: %s, Понимает команды: %s \n",
						resultSet.getInt("Id"),
						resultSet.getString("Name"),
						resultSet.getString("Birthday"),
						resultSet.getString("Gender"),
						resultSet.getString("Commands"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Добавление в DB
	public static void addCatInDB(String tableName, Cats animal) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:animals.db");) {
			Statement statement = connection.createStatement();
			String sqlQuery = String.format(
					"INSERT INTO %s (`Name`, `Birthday`, `Commands`, `Gender`, `Genus_id`)" +
							" VALUES (\"%s\", \"%s\", \"%s\", \"%c\", 1)",
					tableName, animal.getName(), animal.getBirthday(), animal.getComands(), animal.getGender());
			statement.execute(sqlQuery);
			sqlQuery = "UPDATE counter SET value = value + 1 WHERE id = 1";
			statement.execute(sqlQuery);
			Counter.add();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void addDogInDB(String tableName, Dogs animal) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:animals.db");) {
			Statement statement = connection.createStatement();
			String sqlQuery = String.format("INSERT INTO %s (`Name`, `Birthday`, `Commands`, `Gender`, `Genus_id`) VALUES (\"%s\", \"%s\", \"%s\", \"%c\", 1)",
					tableName, animal.getName(),
					animal.getBirthday(),
					animal.getComands(),
					animal.getGender());
			statement.execute(sqlQuery);
			sqlQuery = "UPDATE counter SET value = value + 1 WHERE id = 1";
			statement.execute(sqlQuery);
			Counter.add();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void addHamsterInDB(String tableName, Hamsters animal) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:animals.db");) {
			Statement statement = connection.createStatement();
			String sqlQuery = String.format("INSERT INTO %s (`Name`, `Birthday`, `Commands`, `Gender`, `Genus_id`) VALUES (\"%s\", \"%s\", \"%s\", \"%c\", 1)", tableName, animal.getName(), animal.getBirthday(), animal.getComands(), animal.getGender());
			statement.execute(sqlQuery);
			sqlQuery = "UPDATE counter SET value = value + 1 WHERE id = 1";
			statement.execute(sqlQuery);
			Counter.add();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void addHorseInDB(String tableName, Horses animal) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:animals.db");) {
			Statement statement = connection.createStatement();
			String sqlQuery = String.format("INSERT INTO %s (`Name`, `Birthday`, `Commands`, `Gender`, `Genus_id`) VALUES (\"%s\", \"%s\", \"%s\", \"%c\", 1)", tableName, animal.getName(), animal.getBirthday(), animal.getComands(), animal.getGender());
			statement.execute(sqlQuery);
			sqlQuery = "UPDATE counter SET value = value + 1 WHERE id = 1";
			statement.execute(sqlQuery);
			Counter.add();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void addDonkeyInDB(String tableName, Donkeys animal) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:animals.db");) {
			Statement statement = connection.createStatement();
			String sqlQuery = String.format("INSERT INTO %s (`Name`, `Birthday`, `Commands`, `Gender`, `Genus_id`) VALUES (\"%s\", \"%s\", \"%s\", \"%c\", 1)", tableName, animal.getName(), animal.getBirthday(), animal.getComands(), animal.getGender());
			statement.execute(sqlQuery);
			sqlQuery = "UPDATE counter SET value = value + 1 WHERE id = 1";
			statement.execute(sqlQuery);
			Counter.add();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void addCamelInDB(String tableName, Camels animal) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:animals.db");) {
			Statement statement = connection.createStatement();
			String sqlQuery = String.format("INSERT INTO %s (`Name`, `Birthday`, `Commands`, `Gender`, `Genus_id`) VALUES (\"%s\", \"%s\", \"%s\", \"%c\", 1)", tableName, animal.getName(), animal.getBirthday(), animal.getComands(), animal.getGender());
			statement.execute(sqlQuery);
			sqlQuery = "UPDATE counter SET value = value + 1 WHERE id = 1";
			statement.execute(sqlQuery);
			Counter.add();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	// Удаление из DB
	public static void delAnimalInDB(String tableName, int id) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:animals.db");) {
			Statement statement = connection.createStatement();
			String sqlQuery = String.format("DELETE FROM %s WHERE `Id` = %d;", tableName, id);
			statement.execute(sqlQuery);
			sqlQuery = "UPDATE counter SET value = value - 1 WHERE id = 1";
			statement.execute(sqlQuery);
			Counter.del();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void addComandForAnimal(String command, String table, int id) {

	}

	public static void writCounterInDB(int counter) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:animals.db");) {
			Statement statement = connection.createStatement();
			String sqlQuery = String.format("UPDATE counter SET value = %d WHERE id = 1", counter);
			statement.execute(sqlQuery);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void readCounterInDB() throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:animals.db");) {
			ResultSet resultSet;
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT value FROM counter");
			while (resultSet.next()) {
				Counter.setCounter(resultSet.getInt("value"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void addCommandAnimalInDB(String tableName, int id, String addCommand) throws Exception {
		Class.forName("org.sqlite.JDBC");
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:animals.db");) {
			ResultSet resultSet;
			Statement statement = connection.createStatement();
			String result = String.format("SELECT Commands FROM %s WHERE Id = %d", tableName, id);
			resultSet = statement.executeQuery(result);
			String command;
			while (resultSet.next()) {
				command = (resultSet.getString("Commands"));
				String newCommand = command + ", " + addCommand;
				String sqlQuery = String.format("UPDATE %s SET Commands = '%s' WHERE id = %d", tableName, newCommand, id);
				statement.execute(sqlQuery);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
