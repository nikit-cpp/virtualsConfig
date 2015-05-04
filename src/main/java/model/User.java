package model;

import org.hibernate.validator.constraints.NotEmpty;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class User {
	@XStreamAsAttribute
	@NotEmpty
	private String name;
	
	@XStreamAsAttribute
	@NotEmpty
	private String password;

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public String getLogin() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}
}
