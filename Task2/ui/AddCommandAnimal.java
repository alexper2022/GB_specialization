package Task2.ui;

import Task2.sql.InteractionSql;

import static Task2.services.UserInput.userIn;
import static Task2.ui.Ui.runApp;

public class AddCommandAnimal {
	public static void chooseAddCommandAnAnimal() throws Exception {
		System.out.println("+---------------------------------+");
		System.out.println("|  Кому хотите добавить команду?  |");
		System.out.println("+---------------------------------+");
		System.out.println("| 1. Кошке                        |");
		System.out.println("|---------------------------------|");
		System.out.println("| 2. Собаке                       |");
		System.out.println("|---------------------------------|");
		System.out.println("| 3. Хомяку                       |");
		System.out.println("|---------------------------------|");
		System.out.println("| 4. Лошади                       |");
		System.out.println("|---------------------------------|");
		System.out.println("| 5. Ослу                         |");
		System.out.println("|---------------------------------|");
		System.out.println("| 6. Верблюду                     |");
		System.out.println("|---------------------------------|");
		System.out.println("| 0. Вернуться в основное меню    |");
		System.out.println("+---------------------------------+");
		System.out.print("\nВыберите пункт меню: ");
		switch (userIn().nextInt()) {
			case (1):
				System.out.println("\n-=< Добавить Команду кошке >=-\n");
				AddCommandAnimal.editCat();
				runApp();
			case (2):
				System.out.println("\n-=< Добавить Команду собаке >=-\n");
				AddCommandAnimal.editDog();
				userIn().nextLine();
				runApp();
			case (3):
				System.out.println("\n-=< Добавить Команду хомяку >=-\n");
				AddCommandAnimal.editHamster();
				userIn().nextLine();
				runApp();
			case (4):
				System.out.println("\n-=< Добавить Команду лошади >=-\n");
				AddCommandAnimal.editHorse();
				userIn().nextLine();
				runApp();
			case (5):
				System.out.println("\n-=< Добавить Команду ослу >=-\n");
				AddCommandAnimal.editDonkey();
				userIn().nextLine();
				runApp();
			case (6):
				System.out.println("\n-=< Добавить Команду верблюду >=-\n");
				AddCommandAnimal.editCamel();
				userIn().nextLine();
				runApp();
			case (0):
				runApp();
			default:
				System.out.println("\nВы ошиблись при вводе!\nБудьте внимательны!\n");
				userIn().nextLine();
				chooseAddCommandAnAnimal();
		}
	}


	private static void editCat() throws Exception {
		InteractionSql.viewCats();
		System.out.print("Введите № животного: ");
		int id = userIn().nextInt();
		System.out.print("Введите новую команду: ");
		String command = userIn().nextLine();
		InteractionSql.addCommandAnimalInDB("cats", id, command);
	}

	private static void editDog() throws Exception {
		InteractionSql.viewDogs();
		System.out.print("Введите № животного: ");
		int id = userIn().nextInt();
		System.out.print("Введите новую команду: ");
		String command = userIn().nextLine();
		InteractionSql.addCommandAnimalInDB("dogs", id, command);
	}

	private static void editHamster() throws Exception {
		InteractionSql.viewHamsters();
		System.out.print("Введите № животного: ");
		int id = userIn().nextInt();
		System.out.print("Введите новую команду: ");
		String command = userIn().nextLine();
		InteractionSql.addCommandAnimalInDB("hamsters", id, command);
	}

	private static void editHorse() throws Exception {
		InteractionSql.viewHorses();
		System.out.print("Введите № животного: ");
		int id = userIn().nextInt();
		System.out.print("Введите новую команду: ");
		String command = userIn().nextLine();
		InteractionSql.addCommandAnimalInDB("horses", id, command);
	}

	private static void editDonkey() throws Exception {
		InteractionSql.viewDonkeys();
		System.out.print("Введите № животного: ");
		int id = userIn().nextInt();
		System.out.print("Введите новую команду: ");
		String command = userIn().nextLine();
		InteractionSql.addCommandAnimalInDB("donkeys", id, command);
	}

	private static void editCamel() throws Exception {
		InteractionSql.viewCamels();
		System.out.print("Введите № животного: ");
		int id = userIn().nextInt();
		System.out.print("Введите новую команду: ");
		String command = userIn().nextLine();
		InteractionSql.addCommandAnimalInDB("camels", id, command);
	}
}
