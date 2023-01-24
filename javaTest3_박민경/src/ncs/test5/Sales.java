package ncs.test5;

public class Sales extends Employee implements Bonus {
	
	public Sales() {}
	
	public Sales(String name, int number, String department, int salary) {
		this.setName(name);
		this.setNumber(number);
		this.setDepartment(department);
		this.setSalary(salary);
	}
	

	@Override
	public double tax() {
		return this.getSalary()*0.13;
	}


	@Override
	public void incentive(int pay) {
		
		this.setSalary(this.getSalary() + (int)(pay*1.2));	
	}

}
