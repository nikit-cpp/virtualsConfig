package model;

import javax.validation.constraints.NotNull;

public class Snapshot {
	
	@NotNull
	private String name;
	
	public Snapshot(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Snapshot [name=" + name + "]";
	}
}
