package swa.ass4.client;

import javafx.application.Application;
import swa.ass4.client.gui.LoginScreen;

public class Client {

	private Client() {
	}
	

	public static void main(String args[]) throws Exception {
		Application.launch(LoginScreen.class, args);

	}

}