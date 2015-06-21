package entities;

import lib.pl.btbw.mapper.sparrow.annotation.BtStringProperty;

public class SubCategory {

	private String name;

	private boolean archive;

	@BtStringProperty(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@BtStringProperty(name = "ARCHIVE")
	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}
}
