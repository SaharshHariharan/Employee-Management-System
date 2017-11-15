package hashtables;

public class PartTimeEmployee extends EmployeeInfo {

	private double hourlyWage;
	private double hoursPerWeek;
	private double weeksPerYear;
	
	
	
	public PartTimeEmployee(int empNumber, String firstName, String lastName, Gender gender, Location location,
			double deductRate, double hourlyWage, double hoursPerWeek, double weeksPerYear) {
		super(empNumber, firstName, lastName, gender, location, deductRate);
		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hoursPerWeek;
		this.weeksPerYear=weeksPerYear;
	}

	public double calcAnnualGrossIncome (){		
		return hourlyWage*hoursPerWeek*weeksPerYear;
	}
	
	public double AnnualNetIncome(){
		return calcAnnualGrossIncome()*(1-deductRate);
	}

}
