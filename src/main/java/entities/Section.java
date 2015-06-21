package entities;

import lib.pl.btbw.mapper.siskin.annotation.SetStringProperty;
import lib.pl.btbw.mapper.sparrow.annotation.GetStringProperty;

public class Section {

	private String title;

	private String content = "Lorem Ipsum";

	public Section() {
	}

	public Section(String title) {
		this.title = title;
	}

	@GetStringProperty(name = "TITLE")
	public String getTitle() {
		return title;
	}

	@SetStringProperty(name = "TITLE")
	public void setTitle(String title) {
		this.title = title;
	}

	@GetStringProperty(name = "CONTENT")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Section{" +
				"title='" + title + '\'' +
				", content='" + content + '\'' +
				'}';
	}
}
