package hashtables;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * MyHashTable is a class that will create a HashTable
 * 
 * @author Ani
 *
 */

public class MyHashTable {

	private ArrayList<EmployeeInfo>[] buckets;
	private int k;

	public MyHashTable(int numBuckets) {
		k = numBuckets;
		buckets = new ArrayList[k];
		for (int i = 0; i < k; i++) {
			buckets[i] = new ArrayList<EmployeeInfo>();
		}
	}

	// Methods
	public void addEmployee(EmployeeInfo toAdd) {
		int buck = toAdd.getEmpNumber() % k;
		buckets[buck].add(toAdd);
	}

	public boolean removeEmployee(EmployeeInfo toCut) {
		int buck = toCut.getEmpNumber() % k;
		for (int i = 0; i < buckets[buck].size(); i++) {

			if (buckets[buck].get(i).getEmpNumber() == toCut.getEmpNumber()) {
				buckets[buck].remove(i);
			}
		}

		return true;

	}

	public int search(int toFind) {
		int buck = toFind % k;
		int position = -1;
		for (int i = 0; i < buckets[buck].size() - 1; i++) {

			if (buckets[buck].get(i).getEmpNumber() == toFind) {
				position = i;
			}
		}
		System.out.println("Employee Number "+toFind+ " can be found in bucket "+ buck+ ", position "+ position);
		return position;
	}

	public void displayContents() {

		// Print the employee numbers for the employees stored in each bucket's
		// ArrayList,
		// starting with bucket 0, then bucket 1, and so on.

		for (int i = 0; i < buckets.length; i++) {

			// For the current bucket, print out the emp num for each item
			// in its ArrayList.

			System.out.println("\nExamining the ArrayList for bucket " + i);
			int listSize = buckets[i].size();
			if (listSize == 0) {
				System.out.println("  Nothing in its ArrayList!");
			} else {
				for (int j = 0; j < listSize; j++) {
					int theEmpNum = buckets[i].get(j).getEmpNumber();
					System.out.println("  Employee " + theEmpNum);
				}
			}

		}

	}
        
        public void readFromFile() {
            try {
                FileReader file = new FileReader ("C:/Saharsh/Grade 12/Compsci/EmployeeManagementSystem/EMS");
                BufferedReader reader = new BufferedReader(file);
                String line;
                while ((line = reader.readLine()) != null) {
                    line = reader.readLine();  //reads employee number
                    int empnum = Integer.parseInt(line);
                    line = reader.readLine();  //reads first name
                    String firstname = line;
                    line = reader.readLine();  //reads lastname
                    String lastname = line;
                    line = reader.readLine();  //reads deduct rate
                    double deductrate = Double.parseDouble(line);
                    line = reader.readLine(); // reads gender
                    Gender gender = Gender.valueOf(line); //converts the string value gender into the Gender enum
                    line = reader.readLine();  //reads location
                    Location location = Location.valueOf(line);  //converts the string value location into the Location enum
                    if ((line = reader.readLine()) == "Type: Part Time Employee"){   
                        line = reader.readLine();  //reads hourly wage
                        double hourlywage = Double.parseDouble(line);
                        line = reader.readLine();  //reads hours per week
                        double hoursperweek = Double.parseDouble(line);
                        line = reader.readLine();
                        double weeksperyear = Double.parseDouble(line); //reads weeks per year
                        EmployeeInfo theEmployee = new PartTimeEmployee (empnum, firstname, lastname, gender, location,
			deductrate, hourlywage, hoursperweek, weeksperyear);
                        addEmployee(theEmployee);
                    } else if ((line = reader.readLine()) == "Type: Full Time Employee") {
                        line = reader.readLine();
                        double yearlySalary = Double.parseDouble(line);
                        EmployeeInfo theEmployee = new FullTimeEmployee (empnum, firstname, lastname, gender, location, deductrate, yearlySalary);
                        addEmployee(theEmployee);
                    }
                }
            } catch (Exception e) {
                
            }
        }
        
        public void writeToFile() {
            try {
                PrintWriter writer = new PrintWriter ("data.txt");
                //writer.write(System.getProperty("line.separator")); 
                for (int i = 0; i < buckets.length; i++) {
                    int listSize = buckets[i].size();
                    if (listSize == 0) {
			System.out.println("  Nothing in its ArrayList!");
                    } else if (listSize != 0) {
			for (int j = 0; j < listSize; j++) {
                            EmployeeInfo someEmployee = buckets[i].get(j);
                            writer.println("Employee Number: " + someEmployee.getEmpNumber());
                            writer.println("First Name: " + someEmployee.getFirstName());
                            writer.println("Last  Name:" + someEmployee.getLastName());
                            writer.println("Deduct Rate: " + someEmployee.getDeductRate());
                            writer.println("Gender: " + someEmployee.getGender());
                            writer.println("Location: " + someEmployee.getLocation());
                            if (someEmployee instanceof PartTimeEmployee){
                               writer.println("Type: Part Time Employee");
                               writer.println("Hourly Wage: " + ( (PartTimeEmployee) someEmployee).getHourlyWage());
                               writer.println("Hours Worked Per Week: " + ( (PartTimeEmployee) someEmployee).getHoursPerWeek());
                               writer.println("Weeks Worked Per Year: " + ( (PartTimeEmployee) someEmployee).getWeeksPerYear());
                            } else if (someEmployee instanceof FullTimeEmployee) {
                               writer.println("Type: Full Time Employee");
                               writer.println("Yearly Salary: " + ( (FullTimeEmployee) someEmployee).getYearlySalary());                       
                            } 
                            //riter.write(System.getProperty("line.separator")); 
                        }
                    } 
		}
            writer.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "File Not Found"); //makesure
            }
        }
}

