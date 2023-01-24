package ncs.test1;

public class StringTest {

	public static void main(String[] args) {

		/*
		 * [문제 1] 다음과 같은 조건을 만족하는 프로그램을 작성 하시오 
		 * 주어진 String 데이터를 “,”로 나누어 5개의 실수 데이터들을 꺼내어
		 * 합과 평균을 구한다. 단, String 문자열의 모든 실수 데이터를 배열로 만들어 계산한다.
		 */
		
		String str = "1.22,4.12,5.93,8.71,9.34";
		String[] st = str.split(",");
		
		double[] data = new double[5];
		
		double sum = 0;
		
		for(int i = 0 ; i < data.length ; i++) {
			data[i] = Double.parseDouble(st[i]);
		}
		
		for(double d : data) {
			sum += d;
		}
		
		double avg = sum / data.length;
		
		System.out.print("합계 : ");
		System.out.printf("%.3f",sum);
		System.out.println();
		System.out.print("평균 : ");
		System.out.printf("%.3f", avg);
	}

}
