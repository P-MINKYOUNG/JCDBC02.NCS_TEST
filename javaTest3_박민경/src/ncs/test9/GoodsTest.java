package ncs.test9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodsTest {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Goods goods = new Goods();
		
		try {
			System.out.println("다음 항목의 값을 입력하세요.");
			System.out.print("상품명 : ");
			String name = br.readLine();
			System.out.print("가격 : ");
			int price = Integer.parseInt(br.readLine());
			System.out.print("수량 : ");
			int quantity = Integer.parseInt(br.readLine());
			
			goods.setName(name);
			goods.setPrice(price);
			goods.setQuantity(quantity);
			
			System.out.println("입력된 값은 다음과 같습니다.");
			System.out.println(goods.toString());
			System.out.print("총 구매 가격 : " + goods.getPrice()*goods.getQuantity() + " 원");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
