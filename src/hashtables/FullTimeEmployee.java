package hashtables;

public class FullTimeEmployee extends EmployeeInfo {
	
	private double yearlySalary;

	

	
	public FullTimeEmployee(int empNumber, String firstName, String lastName, Gender gender, Location location,
			double deductRate, double yearlySalary) {
		super(empNumber, firstName, lastName, gender, location, deductRate);
		this.yearlySalary = yearlySalary;
		// TODO Auto-generated constructor stub
	}

	public double AnnualGrossIncome(){
		return this.yearlySalary;
	}
	
	public double calcAnnualNetIncome(){
		return AnnualGrossIncome()*(1-deductRate);
	}
        
        public double getYearlySalary(){
            return this.yearlySalary;
        }
}
