package entities;

import lib.pl.btbw.mapper.siskin.annotation.SetStringProperty;
import lib.pl.btbw.mapper.sparrow.annotation.GetStringProperty;

public class SubCategory {

	private String name;

	private boolean archive;

	@GetStringProperty(name = "NAME")
	public String getName() {
		return name;
	}

	@SetStringProperty(name = "NAME")
	public void setName(String name) {
		this.name = name;
	}

	@GetStringProperty(name = "ARCHIVE")
	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	@Override
	public String toString() {
		return "SubCategory{" +
				"name='" + name + '\'' +
				", archive=" + archive +
				'}';
	}
}
