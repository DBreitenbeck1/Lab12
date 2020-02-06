import java.util.*;
import java.util.regex.Pattern;

public class UsedCarApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Car> listOCars = new ArrayList<Car>();
		Car car1 = new Car("Ford  ", "Focus", 2019, 520000);
		Car car2 = new Car("Ford  ", "Nexus", 2020, 120000);
		Car car3 = new Car("Honda", "Civic", 2019, 90000);
		Car car4 = new Car("Chevy", "Impala", 2019, 105000);

		UsedCar usedCar1 = new UsedCar("Ford  ", "Mustang", 1982, 65000, 240000);
		UsedCar usedCar2 = new UsedCar("Chryslr", "Fury", 1991, 40000, 160000);
		UsedCar usedCar3 = new UsedCar("Toyota", "Tourer", 1999, 72000, 302000);
		UsedCar usedCar4 = new UsedCar("Chevy", "Pinto", 2001, 34000, 295000);

		listOCars.add(car1);
		listOCars.add(usedCar3);
		listOCars.add(car2);
		listOCars.add(usedCar1);
		listOCars.add(car3);
		listOCars.add(car4);
		listOCars.add(usedCar2);
		listOCars.add(usedCar4);

		do {
			showInvent(listOCars);

//		System.out.println("Which car would you like?");
			int s = select(scanner);
			if (s < listOCars.size()) {
				Car c = listOCars.get(s);
				display(c);
				
				if (yesNo(scanner,"Would you like to buy this car?")) {
					System.out.println("It's yours!");
					remove(listOCars, c);
				} else {
					continue;
				}
			} else {
				System.out.println("That is not an option.");
				System.out.println();
				continue;
			}

		
		} while (yesNo(scanner, "Would you like to continue?"));
		System.out.println("Have a good day!");

		scanner.close();
	}

	public static void showInvent(ArrayList<Car> cars) {

		int i = 0;
		for (Car c : cars) {
			i++;
			if (c instanceof UsedCar) {
				UsedCar uc = (UsedCar) c;
				System.out.print(i + ". ");
				System.out.print(uc.getMake() + "\t");
				System.out.print(uc.getModel() + "\t");
				System.out.print(uc.getYear() + "\t");
				System.out.printf("$%,.2f\t", uc.getPrice());
				System.out.print("(Used)");
				System.out.printf("%,.2f", uc.getMileage());
				System.out.print(" miles");
				System.out.println();
			} else {
				System.out.print(i + ". ");
				System.out.print(c.getMake() + "\t");
				System.out.print(c.getModel() + "\t");
				System.out.print(c.getYear() + "\t");
				System.out.printf("$%,.2f\t", c.getPrice());
				System.out.println();
			}
		}
	}

	public static int select(Scanner scan) {
		int i = Validator.getInt(scan, "Which car would you like?");
		i = i - 1;
		return i;
	}

	public static void remove(ArrayList<Car> cars, Car c) {
		cars.remove(c);
	}

	public static void display(Car c) {
		if (c instanceof UsedCar) {
			UsedCar uc = (UsedCar) c;
			System.out.print(uc.getMake() + "\t");
			System.out.print(uc.getModel() + "\t");
			System.out.print(uc.getYear() + "\t");
			System.out.printf("$%,.2f\t", uc.getPrice());
			System.out.print("(used)");
			System.out.printf("%,.2f\t", uc.getMileage());
			System.out.print(" miles");
			System.out.println();

		} else {
			System.out.print(c.getMake() + "\t");
			System.out.print(c.getModel() + "\t");
			System.out.print(c.getYear() + "\t");
			System.out.printf("$%,.2f\t", c.getPrice());
			System.out.println();
		}
	}

	public static boolean yesNo(Scanner scan, String prompt) {
		boolean loop = true;
		System.out.println(prompt);
		String cont = scan.nextLine();

		if (Pattern.matches("[y,n]", cont)) {
			loop = cont.contentEquals("y");
		} else {
			System.out.println("I did not understand that");
			yesNo(scan, prompt);
		}
		return loop;
	}

}
