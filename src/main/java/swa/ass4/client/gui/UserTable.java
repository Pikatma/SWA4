package swa.ass4.client.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import swa.ass4.server.User;
import swa.ass4.server.UserImpl;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UserTable extends Application {

	private TableView<UserImpl> table = new TableView<UserImpl>();

	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) {

		Users list = null;

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

		Scene scene = new Scene(new Group());
		stage.setTitle("User table");
		stage.setWidth(800);
		stage.setHeight(500);

		final Label label = new Label("User table");
		label.setFont(new Font("Arial", 20));

		table.setEditable(true);

		ObservableList<UserImpl> data = FXCollections.observableArrayList();
		for (int i = 0; i < list.size(); i++) {
			data.add(list.getUser(i));
		}

		TableColumn<UserImpl, String> usernameCol = new TableColumn<UserImpl, String>(
				"Username");
		usernameCol
				.setCellValueFactory(new PropertyValueFactory<UserImpl, String>(
						"username"));

		TableColumn<UserImpl, String> nameCol = new TableColumn<UserImpl, String>(
				"Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<UserImpl, String>(
				"name"));
		TableColumn<UserImpl, String> passwordCol = new TableColumn<UserImpl, String>(
				"Password");
		passwordCol
				.setCellValueFactory(new PropertyValueFactory<UserImpl, String>(
						"password"));
		TableColumn<UserImpl, String> emailCol = new TableColumn<UserImpl, String>(
				"Email");
		emailCol.setCellValueFactory(new PropertyValueFactory<UserImpl, String>(
				"email"));
		TableColumn<UserImpl, String> roleCol = new TableColumn<UserImpl, String>(
				"Role");
		roleCol.setCellValueFactory(new PropertyValueFactory<UserImpl, String>(
				"role"));

		table.setItems(data);
		table.getColumns().addAll(usernameCol, nameCol, passwordCol, emailCol,
				roleCol);

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table);

		((Group) scene.getRoot()).getChildren().addAll(vbox);

		stage.setScene(scene);
		stage.show();
	}
}