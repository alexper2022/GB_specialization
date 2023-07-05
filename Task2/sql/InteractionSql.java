package Task2.sql;

import Task2.models.Pets;
import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;
public class InteractionSql {

	// Константа, в которой хранится адрес подключения
	private static final String CON_STR = "jdbc:sqlite:./Task2/Pets.sqlite";

	// Используем шаблон одиночка, чтобы не плодить множество
	// экземпляров класса DbHandler
	private static InteractionSql instance = null;

	public static synchronized InteractionSql getInstance() throws SQLException {
		if (instance == null)
			instance = new InteractionSql();
		return instance;
	}

	// Объект, в котором будет храниться соединение с БД
	private Connection connection;

	private InteractionSql() throws SQLException {
		// Регистрируем драйвер, с которым будем работать
		// в нашем случае Sqlite
		DriverManager.registerDriver(new JDBC());
		// Выполняем подключение к базе данных
		this.connection = DriverManager.getConnection(CON_STR);
	}

	public List<Pets> getAllPets() {

		// Statement используется для того, чтобы выполнить sql-запрос
		try (Statement statement = this.connection.createStatement()) {
			// В данный список будем загружать наши продукты, полученные из БД
			List<Pets> pets = new ArrayList<Pets>();
//			// В resultSet будет храниться результат нашего запроса,
//			// который выполняется командой statement.executeQuery()
//			ResultSet resultSet = statement.executeQuery("SELECT id, good, price, category_name FROM Petss");
//			// Проходимся по нашему resultSet и заносим данные в Pets
//			while (resultSet.next()) {
//				pets.add(new Pets(resultSet.getInt("id"),
//						resultSet.getString("good"),
//						resultSet.getDouble("price"),
//						resultSet.getString("category_name")));
//			}
//			// Возвращаем наш список
			return pets;

		} catch (SQLException e) {
			e.printStackTrace();
			// Если произошла ошибка - возвращаем пустую коллекцию
			return Collections.emptyList();
		}
	}

	// Добавление продукта в БД
//	public void addPets(Pets Pets) {
//		// Создадим подготовленное выражение, чтобы избежать SQL-инъекций
//		try (PreparedStatement statement = this.connection.prepareStatement(
//				"INSERT INTO Petss(`good`, `price`, `category_name`) " +
//						"VALUES(?, ?, ?)")) {
//			statement.setObject(1, Pets.good);
//			statement.setObject(2, Pets.price);
//			statement.setObject(3, Pets.category_name);
//			// Выполняем запрос
//			statement.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	// Удаление продукта по id
	public void deletePets(int id) {
		try (PreparedStatement statement = this.connection.prepareStatement(
				"DELETE FROM Petss WHERE id = ?")) {
			statement.setObject(1, id);
			// Выполняем запрос
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}