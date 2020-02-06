import java.util.*;
import java.util.regex.Pattern;

public class CarApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Car> listOCars = new ArrayList<Car>();

		System.out.println("Welcome to the Java Car Lot");

		do {
			int num = Validator.getInt(scanner, "How many new cars would you like to enter?");

			for (int i = 0; i < num; i++) {
				Car c = makeCar(scanner);
				addCar(listOCars, c);
			}

			System.out.println("Would you like to see your list of cars? [y/n]");

			if (yesNo(scanner)) {
				printList(listOCars);
			}
			System.out.println();
			System.out.println("Would you like to add another car? [y/n]");
		} while (yesNo(scanner));

		System.out.println("Goodbye");

	}

	public static UsedCar makeUsedCar(Scanner scan) {
		System.out.println();
		String make = Validator.getString(scan, "What is your car's make?\n");
		String model = Validator.getString(scan, "What is your car's model?\n");
		int year = Validator.getYear(scan, "What is your car's model year?\n");
		double price = Validator.getDouble(scan, "How much does your car cost?\n");
		double mileage = Validator.getDouble(scan, "How much mileage does your car have?\n");

		UsedCar uc = new UsedCar(make, model, year, price, mileage);

		return uc;

	}

	public static Car makeCar(Scanner scan) {
		System.out.println();
		String make = Validator.getString(scan, "What is your car's make?\n");
		String model = Validator.getString(scan, "What is your car's model?\n");
		int year = Validator.getYear(scan, "What is your car's model year?\n");
		double price = Validator.getDouble(scan, "How much does your car cost?\n");

		Car c = new Car(make, model, year, price);

		return c;
	}

	public static void addCar(ArrayList<Car> cars, Car c) {
		cars.add(c);
	}

	public static void printList(ArrayList<Car> cars) {
		System.out.println("Current inventory:");
		System.out.println("==================");
		for (Car c : cars) {
			System.out.print(c.getMake() + "\t");
			System.out.print(c.getModel() + "\t");
			System.out.print(c.getYear() + "\t");
			System.out.printf("$%,.2f\t", c.getPrice());
			System.out.println();
		}
	}

	public static boolean yesNo(Scanner scan) {
		boolean loop = true;
		String cont = scan.nextLine();

		if (Pattern.matches("[y,n]", cont)) {
			loop = cont.contentEquals("y");
		} else {
			System.out.println("I did not understand that");
			yesNo(scan);
		}
		return loop;
	}

}
