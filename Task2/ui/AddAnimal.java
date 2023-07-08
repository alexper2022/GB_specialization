package Task2.ui;

import Task2.models.*;
import Task2.sql.InteractionSql;

import static Task2.services.UserInput.userIn;
import static Task2.ui.Ui.runApp;

public class AddAnimal {

	public static void chooseAddAnAnimal() throws ClassNotFoundException {
		System.out.println("+---------------------------------+");
		System.out.println("| Какое животное хотите добавить? |");
		System.out.println("+---------------------------------+");
		System.out.println("| 1. Кошки                        |");
		System.out.println("|---------------------------------|");
		System.out.println("| 2. Собаки                       |");
		System.out.println("|---------------------------------|");
		System.out.println("| 3. Хомяки                       |");
		System.out.println("|---------------------------------|");
		System.out.println("| 4. Лошади                       |");
		System.out.println("|---------------------------------|");
		System.out.println("| 5. Ослы                         |");
		System.out.println("|---------------------------------|");
		System.out.println("| 6. Верблюды                     |");
		System.out.println("|---------------------------------|");
		System.out.println("| 0. Вернуться в основное меню    |");
		System.out.println("+---------------------------------+");
		System.out.print("\nВыберите пункт меню: ");
		switch (userIn().nextInt()) {
			case (1):
				System.out.println("\n-=< Добавить кошку >=-\n");
				AddAnimal.addCat();
				runApp();
			case (2):
				System.out.println("\n-=< Добавить собаку >=-\n");
				AddAnimal.addDog();
				userIn().nextLine();
				runApp();
			case (3):
				System.out.println("\n-=< Добавить хомяка >=-\n");
				AddAnimal.addHamster();
				userIn().nextLine();
				runApp();
			case (4):
				System.out.println("\n-=< Добавить лошадь >=-\n");
				AddAnimal.addHorse();
				userIn().nextLine();
				runApp();
			case (5):
				System.out.println("\n-=< Добавить осла >=-\n");
				AddAnimal.addDonkey();
				userIn().nextLine();
				runApp();
			case (6):
				System.out.println("\n-=< Добавить верблюда >=-\n");
				AddAnimal.addCamel();
				userIn().nextLine();
				runApp();
			case (0):
				runApp();
			default:
				System.out.println("\nВы ошиблись при вводе!\nБудьте внимательны!\n");
				userIn().nextLine();
				chooseAddAnAnimal();
		}
	}

	private static void addCat() throws ClassNotFoundException {
		System.out.print("Введите имя животного: ");
		String name = userIn().nextLine();
		System.out.print("Введите день рождения\n в формате гггг-мм-дд (год-месяц-день): ");
		String birthday = userIn().nextLine();
		System.out.print("Введите пол животного (м или ж): ");
		String input = userIn().nextLine();
		if (input.contains("м")){
			Cats cat = new Cats(name, birthday, "", 'м');
			InteractionSql.addCatInDB("cats", cat);
		} else if (input.contains("ж")) {
			Cats cat = new Cats(name, birthday, "", 'ж');
			InteractionSql.addCatInDB("cats", cat);
		}else{
			System.out.println("Вы неправильно ввели пол.");
			addCat();
		}
	}
	private static void addDog() throws ClassNotFoundException {
		System.out.print("Введите имя животного: ");
		String name = userIn().next();
		System.out.print("Введите день рождения\n в формате гггг-мм-дд (год-месяц-день): ");
		String birthday = userIn().nextLine();
		System.out.print("Введите пол животного (м или ж): ");
		String input = userIn().nextLine();
		if (input.contains("м")){
			Dogs dog = new Dogs(name, birthday, "", 'м');
			InteractionSql.addDogInDB("dogs", dog);
		} else if (input.contains("ж")) {
			Dogs dog = new Dogs(name, birthday, "", 'ж');
			InteractionSql.addDogInDB("dogs", dog);
		}else{
			System.out.println("Вы неправильно ввели пол.");
			addDog();
		}
	}
	private static void addHamster() throws ClassNotFoundException {
		System.out.print("Введите имя животного: ");
		String name = userIn().nextLine();
		System.out.print("Введите день рождения\n в формате гггг-мм-дд (год-месяц-день): ");
		String birthday = userIn().nextLine();
		System.out.print("Введите пол животного (м или ж): ");
		String input = userIn().nextLine();
		if (input.contains("м")){
			Hamsters hamster = new Hamsters(name, birthday, "", 'м');
			InteractionSql.addHamsterInDB("hamsters", hamster);
		} else if (input.contains("ж")) {
			Hamsters hamster = new Hamsters(name, birthday, "", 'ж');
			InteractionSql.addHamsterInDB("hamsters", hamster);
		}else{
			System.out.println("Вы неправильно ввели пол.");
			addHamster();
		}
	}
	private static void addHorse() throws ClassNotFoundException {
		System.out.print("Введите имя животного: ");
		String name = (String) userIn().nextLine();
		System.out.print("Введите день рождения\n в формате гггг-мм-дд (год-месяц-день): ");
		String birthday = userIn().nextLine();
		System.out.print("Введите пол животного (м или ж): ");
		String input = userIn().nextLine();
		if (input.contains("м")){
			Horses horse = new Horses(name, birthday, "", 'м');
			InteractionSql.addHorseInDB("horses", horse);
		} else if (input.contains("ж")) {
			Horses horse = new Horses(name, birthday, "", 'ж');
			InteractionSql.addHorseInDB("horses", horse);
		}else{
			System.out.println("Вы неправильно ввели пол.");
			addHorse();
		}
	}
	private static void addDonkey() throws ClassNotFoundException {
		System.out.print("Введите имя животного: ");
		String name = (String) userIn().nextLine();
		System.out.print("Введите день рождения\n в формате гггг-мм-дд (год-месяц-день): ");
		String birthday = userIn().nextLine();
		System.out.print("Введите пол животного (м или ж): ");
		String input = userIn().nextLine();
		if (input.contains("м")){
			Donkeys donkey = new Donkeys(name, birthday, "", 'м');
			InteractionSql.addDonkeyInDB("donkeys", donkey);
		} else if (input.contains("ж")) {
			Donkeys donkey = new Donkeys(name, birthday, "", 'ж');
			InteractionSql.addDonkeyInDB("donkeys", donkey);
		}else{
			System.out.println("Вы неправильно ввели пол.");
			addDonkey();
		}
	}
	private static void addCamel() throws ClassNotFoundException {
		System.out.print("Введите имя животного: ");
		String name = (String) userIn().nextLine();
		System.out.print("Введите день рождения\n в формате гггг-мм-дд (год-месяц-день): ");
		String birthday = userIn().nextLine();
		System.out.print("Введите пол животного (м или ж): ");
		String input = userIn().nextLine();
		if (input.contains("м")){
			Camels camel = new Camels(name, birthday, "", 'м');
			InteractionSql.addCamelInDB("camels", camel);
		} else if (input.contains("ж")) {
			Camels camel = new Camels(name, birthday, "", 'ж');
			InteractionSql.addCamelInDB("camels", camel);
		}else{
			System.out.println("Вы неправильно ввели пол.");
			addCamel();
		}
	}
}
