package entities;

import lib.pl.btbw.mapper.annotation.BtObjectProperty;
import lib.pl.btbw.mapper.annotation.BtStringProperty;

public class Category {

	private String name;

	private SubCategory subCategory;

	public Category() {
	}

	@BtStringProperty(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@BtObjectProperty(name = "SUB_CATEGORY")
	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
}
