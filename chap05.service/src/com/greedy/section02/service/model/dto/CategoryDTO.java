package com.greedy.section02.service.model.dto;

public class CategoryDTO {
	
	private int categoryCode;
	private String categoryName;
	private Integer refCategoryCode;
	
	public CategoryDTO() {}

	public CategoryDTO(int categoryCode, String categoryName, Integer refCategoryCode) {
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

	// null 값을 처리하기 위해 Integer 타입으로 인자를 받는다.
	public void setRefCategoryCode(Integer refCategoryCode) {
		this.refCategoryCode = refCategoryCode;
	}

	@Override
	public String toString() {
		return 			"[" 
						+ "카테고리 코드 : " + categoryCode + "\n"
	                    + "카테고리 이름 : " + categoryName + "\n" 
	                    + "선행카테고리 코드 : " + refCategoryCode 
	                    + "]" + "\n";
	};
	
	

}
