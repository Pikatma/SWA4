package swa.ass4.server;

import javax.jws.WebService;

@WebService
public interface User {
	public String getUsername();

	public void setUsername(String id);

	public String getName();

	public void setName(String name);

	public String getPassword();

	public void setPassword(String password);

	public String getEmail();

	public void setEmail(String email);

	public String getRole();

	public void setRole(String role);
}
