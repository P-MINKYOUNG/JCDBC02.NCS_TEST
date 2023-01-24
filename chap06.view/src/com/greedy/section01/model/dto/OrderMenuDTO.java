package com.greedy.section01.model.dto;

public class OrderMenuDTO {
	
	/*ORDER_CODE	NUMBER
	MENU_CODE	NUMBER
	ORDER_AMOUNT	NUMBER*/
	
	private int orderCode;
	private int menuCode;
	private int orderAmount;
	
	public OrderMenuDTO() {}

	public OrderMenuDTO(int orderCode, int menuCode, int orderAmount) {
		super();
		this.orderCode = orderCode;
		this.menuCode = menuCode;
		this.orderAmount = orderAmount;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public int getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	@Override
	public String toString() {
		return "주문 번호 : " + orderCode + "\n" 
			 + "메뉴 번호 : " + menuCode +"\n"
			 + "주문 수량 : " + orderAmount + "\n";
	};
	
	

}
