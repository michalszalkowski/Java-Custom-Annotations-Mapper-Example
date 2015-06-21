package entities;

import lib.pl.btbw.mapper.annotation.BtListProperty;
import lib.pl.btbw.mapper.annotation.BtObjectProperty;
import lib.pl.btbw.mapper.annotation.BtStringProperty;

import java.util.ArrayList;
import java.util.List;

public class Article {

	private String title;

	private int type;

	private Category category;

	private List<Section> sections = new ArrayList<>();

	public Article() {
	}

	@BtStringProperty(name = "TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@BtStringProperty(name = "TYPE")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@BtObjectProperty(name = "CATEGORY")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@BtListProperty(name = "SECTIONS")
	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
}
