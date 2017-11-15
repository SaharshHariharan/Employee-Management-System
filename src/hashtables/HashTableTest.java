package hashtables;

public class HashTableTest {

	public static void main(String[] args) {

		MyHashTable theHT = new MyHashTable(2);

		EmployeeInfo someEmp;

		someEmp = new EmployeeInfo(757442, "Daffy", "Duck", Gender.MALE, Location.TORONTO, 0.23);
		theHT.addEmployee(someEmp);

		someEmp = new EmployeeInfo(907263, "Leghorn", "Foghorn", Gender.OTHER, Location.MISSISSAUGA, 0.19);
		theHT.addEmployee(someEmp);

		someEmp = new EmployeeInfo(186484, "Lola", "Bunny", Gender.FEMALE, Location.BRAMPTON, 0.20);
		theHT.addEmployee(someEmp);

		someEmp = new EmployeeInfo(888885, "Bugs", "Bunny", Gender.MALE, Location.TORONTO, 0.21);
		theHT.addEmployee(someEmp);

		someEmp = new EmployeeInfo(795306, "Marvin", "Martian", Gender.OTHER, Location.MISSISSAUGA, 0.15);
		theHT.addEmployee(someEmp);

		someEmp = new EmployeeInfo(390217, "Sylvester", "Cat", Gender.MALE, Location.BRAMPTON, 0.27);
		theHT.addEmployee(someEmp);

		theHT.displayContents();
		theHT.search(888885);
		theHT.search(186484);
		theHT.removeEmployee(someEmp);
		theHT.displayContents();

	}

}