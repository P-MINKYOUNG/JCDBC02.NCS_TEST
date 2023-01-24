package ncs.test5;

public class Company {

	public static void main(String[] args) {
		
		Employee[] employees = new Employee[2];
		
		Secretary secretary = new Secretary("Hilery", 1, "secretary", 800);
		Sales sales = new Sales("Clinten", 2, "sales", 1200);
		
		employees[0] = (secretary);
		employees[1] = (sales);
		
		System.out.println("Name     Department  Salary");
		System.out.println("===========================");
		for(int i = 0 ; i < employees.length ; i++) {
			System.out.println(employees[i].toString());
		}
		System.out.println();
		System.out.println("====== 인센티브 100 지급 ======");
		secretary.incentive(100);
		sales.incentive(100);
		System.out.println("===========================");
		System.out.println();
		System.out.println("Name     Department  Salary   tax");
		System.out.println("==================================");
		System.out.println(employees[0].toString() + "      " + secretary.tax());
		System.out.println(employees[1].toString() + "        " + sales.tax());

	}

}
