package ncs.test3;

public class Calculator {

	public double getSum(int data) {
		
		double sum = 0;
		
		if (data >= 2 && data <= 5) {
			for (int i = 1; i <= data; i++) {
				
				sum += i;
			
			}
		}else {
			
			String message = "입력 값에 오류가 있습니다.";
			
			InvalidException exception = new InvalidException();
			exception.InvalidException(message);
		}
		
		return sum;
	}

}
