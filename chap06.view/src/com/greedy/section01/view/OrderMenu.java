package com.greedy.section01.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.greedy.section01.model.dto.CategoryDTO;
import com.greedy.section01.model.dto.MenuDTO;
import com.greedy.section01.model.dto.OrderMenuDTO;
import com.greedy.section01.model.service.OrderService;

public class OrderMenu {
	
	private OrderService orderService = new OrderService();

	public void displayMenu() {
		
		/*반복
		 * -----------------------------
		 *1. 카테고리 목록 조회 -> 선택
		 *2. 해당 카테고리의 메뉴 조회 -> 선택
		 *3. 메뉴 선택 후 주문 수량 입력
		 *------------------------------
		 *4. 주문*/
		
		Scanner sc = new Scanner(System.in);
		
		List<OrderMenuDTO> orderMenuList = new ArrayList<>();
		int totalOrderPrice = 0;
		
		
		do {
			System.out.println("============ 음식 주문 프로그램 ============");
			List<CategoryDTO> categoryList = orderService.selectAllCategory();
			for(CategoryDTO category : categoryList) {
				System.out.println(category.getCategoryName());
			}
			
			System.out.println("=========================================");
			String inputCategoryName = sc.nextLine();
			
			int categoryCode = 0;
			
			for(CategoryDTO category : categoryList) {
				if(category.getCategoryName().equals(inputCategoryName)) {
					categoryCode = category.getCategoryCode();
				}
			}
			
			System.out.println("=============" + inputCategoryName + " 주문 가능 메뉴 =============");
			List<MenuDTO> menuList = orderService.selectMenuByCategory(categoryCode);
			
			for(MenuDTO menu : menuList) {
				System.out.println(menu.toString());
			}
			
			
			System.out.print("주문하실 메뉴를 선택하세요 : ");
			String inputMenu = sc.nextLine();
			System.out.print("주문하실 수량을 입력하세요 : ");
			int orderAmount = sc.nextInt();
			sc.nextLine();
			
			int menuCode = 0;
			int menuPrice = 0;
			
			for(MenuDTO menu : menuList){
				if(menu.getMenuName().equals(inputMenu)) {
					menuCode = menu.getMenuCode();
					menuPrice = menu.getMenuPrice();
				}
			}
			
			OrderMenuDTO orderMenu = new OrderMenuDTO();
			orderMenu.setMenuCode(menuCode);
			orderMenu.setOrderAmount(orderAmount);
			
			orderMenuList.add(orderMenu);
			totalOrderPrice += (menuPrice * orderAmount);
			
			System.out.print("계속 주문하시겠습니까? (예 / 아니오) : ");
			boolean isContinue = sc.nextLine().equals("예");
			
			if(!isContinue) break;
		} while(true);
		
		for(OrderMenuDTO orderMenu : orderMenuList) {
			System.out.println("주문 메뉴 : " + orderMenu.toString());
		}
		
		System.out.println("주문 총액 : " + totalOrderPrice);
		
	}

}
