package com.greedy.section01.DTO;

public class CategoryDTO {
	
	private int categoryCode;
	private String categoryName;
	private int refCategoryCode;
	
	public CategoryDTO() {}

	public CategoryDTO(int categoryCode, String categoryName, int refCategoryCode) {
		super();
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.refCategoryCode = refCategoryCode;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getRefCategoryCode() {
		return refCategoryCode;
	}

	public void setRefCategoryCode(int refCategoryCode) {
		this.refCategoryCode = refCategoryCode;
	}

	@Override
	public String toString() {
		return 			"[" 
						+ "categoryCode=" + categoryCode + "\n"
	                    + "categoryName=" + categoryName + "\n" 
	                    + "refCategoryCode=" + refCategoryCode 
	                    + "]" + "\n";
	};
	
	

}
