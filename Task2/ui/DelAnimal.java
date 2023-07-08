package Task2.ui;

import Task2.services.UserInput;
import Task2.sql.InteractionSql;

import static Task2.services.UserInput.userIn;
import static Task2.ui.Ui.runApp;

public class DelAnimal {

	public static void chooseDelAnAnimal() throws Exception {
		System.out.println("+---------------------------------+");
		System.out.println("| Какое животное хотите удалить?  |");
		System.out.println("+---------------------------------+");
		System.out.println("| 1. Кошку                        |");
		System.out.println("|---------------------------------|");
		System.out.println("| 2. Собаку                       |");
		System.out.println("|---------------------------------|");
		System.out.println("| 3. Хомяка                       |");
		System.out.println("|---------------------------------|");
		System.out.println("| 4. Лошадь                       |");
		System.out.println("|---------------------------------|");
		System.out.println("| 5. Осла                         |");
		System.out.println("|---------------------------------|");
		System.out.println("| 6. Верблюда                     |");
		System.out.println("|---------------------------------|");
		System.out.println("| 0. Вернуться в основное меню    |");
		System.out.println("+---------------------------------+");
		System.out.print("\nВыберите пункт меню: ");
		switch (userIn().nextInt()) {
			case (1):
				System.out.println("\n-=< Удалить кошку >=-\n");
				DelAnimal.delCat();
				runApp();
			case (2):
				System.out.println("\n-=< Удалить собаку >=-\n");
				DelAnimal.delDog();
				userIn().nextLine();
				runApp();
			case (3):
				System.out.println("\n-=< Удалить хомяка >=-\n");
				DelAnimal.delHamster();
				userIn().nextLine();
				runApp();
			case (4):
				System.out.println("\n-=< Удалить лошадь >=-\n");
				DelAnimal.delHorse();
				userIn().nextLine();
				runApp();
			case (5):
				System.out.println("\n-=< Удалить осла >=-\n");
				DelAnimal.delDonkey();
				userIn().nextLine();
				runApp();
			case (6):
				System.out.println("\n-=< Удалить верблюда >=-\n");
				DelAnimal.delCamel();
				runApp();
			case (0):
				runApp();
			default:
				System.out.println("\nВы ошиблись при вводе!\nБудьте внимательны!\n");
				userIn().nextLine();
				chooseDelAnAnimal();
		}
	}

	private static void delCat() throws Exception {
		InteractionSql.viewCats();
		System.out.print("Введите № животного: ");
		int id = UserInput.userIn().nextInt();
		InteractionSql.delAnimalInDB("cats", id);
	}

	private static void delDog() throws Exception {
		InteractionSql.viewDogs();
		System.out.print("Введите № животного: ");
		int id = UserInput.userIn().nextInt();
		InteractionSql.delAnimalInDB("dogs", id);
	}

	private static void delHamster() throws Exception {
		InteractionSql.viewHamsters();
		System.out.print("Введите № животного: ");
		int id = UserInput.userIn().nextInt();
		InteractionSql.delAnimalInDB("hamsters", id);
	}


	private static void delHorse() throws Exception {
		InteractionSql.viewHorses();
		System.out.print("Введите № животного: ");
		int id = UserInput.userIn().nextInt();
		InteractionSql.delAnimalInDB("horses", id);
	}

	private static void delDonkey() throws Exception {
		InteractionSql.viewDonkeys();
		System.out.print("Введите № животного: ");
		int id = UserInput.userIn().nextInt();
		InteractionSql.delAnimalInDB("donkeys", id);
	}

	private static void delCamel() throws Exception {
		InteractionSql.viewCamels();
		System.out.print("Введите № животного: ");
		int id = UserInput.userIn().nextInt();
		InteractionSql.delAnimalInDB("camels", id);
	}

}
