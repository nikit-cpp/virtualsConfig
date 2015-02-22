package virtualsConfig;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class User {
	@XStreamAsAttribute
	private String login;
	@XStreamAsAttribute
	private String password;

	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
}
