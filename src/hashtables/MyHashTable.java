package hashtables;

import java.util.ArrayList;

/**
 * MyHashTable is a class that will create a hashtable
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
}