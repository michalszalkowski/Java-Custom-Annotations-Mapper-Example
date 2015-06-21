package entities;

import lib.pl.btbw.mapper.siskin.annotation.SetObjectProperty;
import lib.pl.btbw.mapper.siskin.annotation.SetStringProperty;
import lib.pl.btbw.mapper.sparrow.annotation.GetObjectProperty;
import lib.pl.btbw.mapper.sparrow.annotation.GetStringProperty;

public class Category {

	private String name;

	private SubCategory subCategory;

	public Category() {
	}

	@GetStringProperty(name = "NAME")
	public String getName() {
		return name;
	}

	@SetStringProperty(name = "NAME")
	public void setName(String name) {
		this.name = name;
	}

	@GetObjectProperty(name = "SUB_CATEGORY")
	public SubCategory getSubCategory() {
		return subCategory;
	}

	@SetObjectProperty(name = "SUB_CATEGORY")
	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "Category{" +
				"name='" + name + '\'' +
				", subCategory=" + subCategory +
				'}';
	}
}
