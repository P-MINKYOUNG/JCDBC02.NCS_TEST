package ncs.test8;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Inventory {

	private String productName;
	private Date putDate;
	private Date getDate;
	private int putAmount;
	private int getAmount;
	private int inventoryAmount;

	public Inventory() {
	}

	public Inventory(String productName, Date putDate, Date getDate, int putAmount, int getAmount,
			int inventoryAmount) {
		super();
		this.productName = productName;
		this.putDate = putDate;
		this.getDate = getDate;
		this.putAmount = putAmount;
		this.getAmount = getAmount;
		this.inventoryAmount = putAmount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getPutDate() {
		return putDate;
	}

	public void setPutDate(Date putDate) {
		this.putDate = putDate;
	}

	public Date getGetDate() {
		return getDate;
	}

	public void setGetDate(Date setDate) {
		this.getDate = setDate;
	}

	public int getPutAmount() {
		return putAmount;
	}

	public void setPutAmount(int putAmount) {
		this.putAmount = putAmount;
	}

	public int getGetAmount() {
		return getAmount;
	}

	public void setGetAmount(int getAmount) throws AmountNotEnough {
			if (getAmount < putAmount) {
				this.inventoryAmount = (putAmount - getAmount);
				this.getAmount = getAmount;
			}else throw new AmountNotEnough("현재 재고가 부족합니다. 재고수량 확인하시기 바랍니다.");
	}

	public int getInventoryAmount() {
		return inventoryAmount;
	}

	public void setInventoryAmount(int inventoryAmount) {
		this.inventoryAmount = inventoryAmount;
	}

	@Override
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일 E요일");
		
		
		return productName + ", \t\t" + sdf.format(putDate) + "입고,\t\t" + putAmount + "개\t\t" + sdf.format(getDate) + "출고,\t\t" + getAmount
				+ "개\t\t 재고 " + inventoryAmount + "개";
	}

}
