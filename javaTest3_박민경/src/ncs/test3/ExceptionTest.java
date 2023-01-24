package ncs.test3;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("2 부터 5 사이의 정수를 하나 입력하세요 : ");
		
		int data = sc.nextInt();
		
		Calculator cal = new Calculator();
		System.out.println(cal.getSum(data));
	}

}
