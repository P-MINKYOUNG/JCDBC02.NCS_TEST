package ncs.test5;

public class Secretary extends Employee implements Bonus {
	
	public Secretary() {}
	
	public Secretary(String name, int number, String department, int salary) {
		this.setName(name);
		this.setNumber(number);
		this.setDepartment(department);
		this.setSalary(salary);
	}
	

	@Override
	public double tax() {
		return this.getSalary()*0.1;
	}

	@Override
	public void incentive(int pay) {
		
		this.setSalary(this.getSalary() + (int)(pay*0.8));		
	}


}
