package model;

import org.hibernate.validator.constraints.NotEmpty;

public class Snapshot {
	
	@NotEmpty
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
