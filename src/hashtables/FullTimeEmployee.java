package hashtables;

public class FullTimeEmployee extends EmployeeInfo {
	
	private double yearlySalary;

	

	
	public FullTimeEmployee(int empNumber, String firstName, String lastName, Gender gender, Location location,
			double deductRate, int yearlySalary) {
		super(empNumber, firstName, lastName, gender, location, deductRate);
		this.yearlySalary = yearlySalary;
		// TODO Auto-generated constructor stub
	}

	public double calcAnnualGrossIncome(){
		return this.yearlySalary;
	}
	
	public double AnnualNetIncome(){
		return calcAnnualGrossIncome()*(1-deductRate);
	}
}
