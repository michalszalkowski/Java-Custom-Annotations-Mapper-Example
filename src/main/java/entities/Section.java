package entities;

import lib.pl.btbw.mapper.annotation.BtStringProperty;

public class Section {

	private String title;

	private String content = "Lorem Ipsum";

	public Section() {
	}

	public Section(String title) {
		this.title = title;
	}

	@BtStringProperty(name = "TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@BtStringProperty(name = "CONTENT")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
