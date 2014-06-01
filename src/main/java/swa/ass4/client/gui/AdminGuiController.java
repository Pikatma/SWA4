package swa.ass4.client.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import swa.ass4.server.UserImpl;

public class AdminGuiController {
	@FXML
	private TableView<UserImpl> tableView;
	@FXML
	private TableColumn<UserImpl, String> usernameColumn;
//	@FXML
//	private Label usernameLabel;
	// @FXML
	// private TextField nameColumn;
	// @FXML
	// private TextField passwordColumn;
	// @FXML
	// private TextField emailColumn;
	// @FXML
	// private TextField roleColumn;
	@FXML
	private TextField usernameField;
	@FXML
	private TextField nameField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField passwordField;
	@FXML
	private TextField roleField;

	@FXML
	public void initialize() {
		 Users list = null;
		 TableView<UserImpl> table = new TableView<UserImpl>();
		
		 try {
		 URL url = new URL("http://localhost:9000/users/user/all");
		 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		 conn.setRequestMethod("GET");
		 conn.setRequestProperty("Accept", "application/xml");
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(
		 (conn.getInputStream())));
		 String apiOutput = br.readLine();
		 System.out.println(apiOutput);
		 conn.disconnect();
		
		 JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
		 Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		 list = (Users) jaxbUnmarshaller.unmarshal(new StringReader(
		 apiOutput));
		
		 } catch (MalformedURLException e) {
		 e.printStackTrace();
		 } catch (IOException e) {
		 e.printStackTrace();
		 } catch (JAXBException e) {
		 e.printStackTrace();
		 }
		 table.setEditable(true);
		 
		  ObservableList<UserImpl> data = FXCollections.observableArrayList();
		  for (int i = 0; i < list.size(); i++) {
		  data.add(list.getUser(i));
		  }
		  
		  
		  System.out.print(data);
		 
		usernameColumn
				.setCellValueFactory(new PropertyValueFactory<UserImpl, String>(
						"username"));
		tableView.getItems();

	}

	

	@FXML
	protected void addPerson(ActionEvent event) {
		// ObservableList<Person> data = tableView.getItems();
		// data.add(new Person(usernameField.getText(), nameField.getText(),
		// emailField.getText(), passwordField.getText(), roleField
		// .getText()));
		//
		// usernameField.setText("");
		// nameField.setText("");
		// emailField.setText("");
		// passwordField.setText("");
		// roleField.setText("");
	}
}

// @FXML
// private Text actiontarget;
//
// @FXML
// private TextField Username;
//
// @FXML
// private PasswordField passwordField;
//
// @FXML
// protected void handleSubmitButtonAction(ActionEvent event) {
// Users list = null;
// TableView<UserImpl> table = new TableView<UserImpl>();
//
// try {
// URL url = new URL("http://localhost:9000/users/user/all");
// HttpURLConnection conn = (HttpURLConnection) url.openConnection();
// conn.setRequestMethod("GET");
// conn.setRequestProperty("Accept", "application/xml");
//
// BufferedReader br = new BufferedReader(new InputStreamReader(
// (conn.getInputStream())));
// String apiOutput = br.readLine();
// System.out.println(apiOutput);
// conn.disconnect();
//
// JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
// Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
// list = (Users) jaxbUnmarshaller.unmarshal(new StringReader(
// apiOutput));
//
// } catch (MalformedURLException e) {
// e.printStackTrace();
// } catch (IOException e) {
// e.printStackTrace();
// } catch (JAXBException e) {
// e.printStackTrace();
// }
//
// table.setEditable(true);
//
// ObservableList<UserImpl> data = FXCollections.observableArrayList();
// for (int i = 0; i < list.size(); i++) {
// data.add(list.getUser(i));
// }
//
// }
// }