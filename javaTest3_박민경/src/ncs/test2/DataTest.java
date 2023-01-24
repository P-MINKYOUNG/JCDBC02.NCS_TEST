package ncs.test2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataTest {

	public static void main(String[] args) {
		
		/*
		 * [문제 2] 다음과 같은 조건을 만족하는 프로그램을 작성 하시오. 
		 * GregorianCalendar 클래스를 사용하여, 현재 년도와 비교한
		 * 나이를 계산하고 생일의 요일을 출력 한다. 
		 * 출력시 SimpleDateFormat 을 사용하여 출력한다.
		 * 
		 * */
		
		GregorianCalendar gcal = new GregorianCalendar();
		int day = gcal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(day);

	}

}
