package Boutons;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.Event;
import javafx.event.*;

public class Boutons extends Application{
	public void start(Stage stage) {
		stage.setTitle("Juste un Bouton");
		Button b = new Button("0");
		b.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				int compt = Integer.parseInt(b.getText()) + 1;
				b.setText(""+compt);
			}
		});
		Scene scene = new Scene(b);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main (String[] args) {
		launch(args);
	}
}
