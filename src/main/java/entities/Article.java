package entities;

import lib.pl.btbw.mapper.siskin.annotation.SetListProperty;
import lib.pl.btbw.mapper.siskin.annotation.SetObjectProperty;
import lib.pl.btbw.mapper.siskin.annotation.SetStringProperty;
import lib.pl.btbw.mapper.sparrow.annotation.GetListProperty;
import lib.pl.btbw.mapper.sparrow.annotation.GetObjectProperty;
import lib.pl.btbw.mapper.sparrow.annotation.GetStringProperty;

import java.util.List;

public class Article {

	private String title;

	private int type;

	private Category category;

	private List<Section> sections;

	public Article() {
	}

	@GetStringProperty(name = "TITLE")
	public String getTitle() {
		return title;
	}

	@SetStringProperty(name = "TITLE")
	public void setTitle(String title) {
		this.title = title;
	}

	@GetStringProperty(name = "TYPE")
	public int getType() {
		return type;
	}

	@SetStringProperty(name = "TYPE")
	public void setType(int type) {
		this.type = type;
	}

	@GetObjectProperty(name = "CATEGORY")
	public Category getCategory() {
		return category;
	}

	@SetObjectProperty(name = "CATEGORY")
	public void setCategory(Category category) {
		this.category = category;
	}

	@GetListProperty(name = "SECTIONS")
	public List<Section> getSections() {
		return sections;
	}

	@SetListProperty(name = "SECTIONS", type = Section.class)
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	@Override
	public String toString() {
		return "Article{" +
				"title='" + title + '\'' +
				", type=" + type +
				", category=" + category +
				", sections=" + sections +
				'}';
	}
}
