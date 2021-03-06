package swa.ass4.client.gui;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import swa.ass4.server.UserImpl;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {
	@XmlElement(name = "user")
	private List<UserImpl> users;

	public List<UserImpl> getUsers() {
		return users;
	}

	public UserImpl getUser(int i) {
		return users.get(i);
	}

	public UserImpl getUser(String username) {
		return getUser(username);
	}

	public void setUsers(List<UserImpl> users) {
		this.users = users;
	}

	public int size() {
		return users.size();
	}
}