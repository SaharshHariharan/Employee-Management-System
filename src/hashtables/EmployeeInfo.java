package hashtables;

public class EmployeeInfo {
	protected String firstName;
	protected String lastName;
	protected int empNumber;
	protected Gender gender;
	protected Location location;
	protected double deductRate;
	
	public EmployeeInfo(int empNumber, String firstName, String lastName, Gender gender, Location location,
			double deductRate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.empNumber = empNumber;
		this.gender = gender;
		this.location = location;
		this.deductRate = deductRate;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public int getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}
	public double getDeductRate() {
		return deductRate;
	}
	public void setDeductRate(double deductRate) {
		this.deductRate = deductRate;
	}
	
	public void displayEmployee() {
		System.out.println(this.firstName+" "+this.lastName+", "+this.empNumber);
		if (this instanceof PartTimeEmployee){
			PartTimeEmployee thePTE = (PartTimeEmployee) this;
			 System.out.println("Hourly Wage: "+thePTE.calcAnnualGrossIncome());
		} else if (this instanceof FullTimeEmployee){
			FullTimeEmployee theFTE = (FullTimeEmployee) this;
			 System.out.println("Hourly Wage: "+theFTE.AnnualGrossIncome());
		}
	}
	
}
