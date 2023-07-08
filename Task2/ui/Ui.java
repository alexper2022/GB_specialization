package Task2.ui;

import Task2.models.Counter;
import Task2.sql.InteractionSql;

import static Task2.services.UserInput.userIn;

public class Ui {
	public static void runApp() {
		int counterAnimal = Counter.getCounter();
		try {
			System.out.println("+------------------------------------------+");
			System.out.println("|                   МЕНЮ                   |");
			System.out.println("+------------------------------------------+");
			System.out.println("| 1. Вывести список всех животных.         |");
			System.out.println("|------------------------------------------|");
			System.out.println("| 2. Добавить новую команду животному.     |");
			System.out.println("|------------------------------------------|");
			System.out.println("| 3. Добавить животное.                    |");
			System.out.println("|------------------------------------------|");
			System.out.println("| 4. Удалить животное.                     |");
			System.out.println("|------------------------------------------|");
			System.out.println("| 0. Выйти из программы                    |");
			System.out.println("+------------------------------------------+");
			System.out.printf("  Животных в базе: %d\n", counterAnimal);
			System.out.print("\nВыберите пункт меню: ");
			switch (userIn().nextInt()) {
				case (1):
					if (counterAnimal > 0) {
						System.out.println("\n-=< Вывести список всех животных >=-");
						System.out.println("\n-=< Домашние животные >=-");
						InteractionSql.viewCats();
						InteractionSql.viewDogs();
						InteractionSql.viewHamsters();
						System.out.println("\n-=< Вьючные животные >=-");
						InteractionSql.viewHorses();
						InteractionSql.viewDonkeys();
						InteractionSql.viewCamels();
						System.out.printf("Животных в базе: %d\n", counterAnimal);
					} else {
						System.out.println("\n\nБаза животных пуста!!!\n");
					}
					System.out.print("Для продолжения нажмите Enter...");
					userIn().nextLine();
					runApp();
				case (2):
					System.out.println("\n-=< Добавить новую команду животному >=-\n");
					if (counterAnimal > 0) {
						AddCommandAnimal.chooseAddCommandAnAnimal();
					} else {
						System.out.println("\n\nБаза животных пуста!!!\nДобавлять команду нельзя!!!\n");
					}
					System.out.print("Для продолжения нажмите Enter...");
					userIn().nextLine();
					runApp();
				case (3):
					AddAnimal.chooseAddAnAnimal();
					runApp();
				case (4):
					if (counterAnimal > 0) {
						DelAnimal.chooseDelAnAnimal();
					} else {
						System.out.println("\n\nБаза животных пуста!!!\nУдалять нечего!!!\n");
					}
					System.out.print("Для продолжения нажмите Enter...");
					userIn().nextLine();
					runApp();
				case (0):
					System.out.println("\n-=< Выйти из программы >=-\n");
					System.out.println("Спасибо, что пользуетесь нашей программой!");
					userIn().close();
					System.exit(0);
				default:
					System.out.println("\nВы ошиблись при вводе!\nБудьте внимательны!\n");
					userIn().nextLine();
					runApp();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			runApp();
		}
	}
}
