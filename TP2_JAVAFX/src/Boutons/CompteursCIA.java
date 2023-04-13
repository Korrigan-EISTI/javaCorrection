package Boutons;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.event.*;
import javafx.scene.layout.HBox;

public class CompteursCIA extends Application{
	public void start(Stage stage){
		Button b = new Button("0");
		b.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				int compt = Integer.parseInt(b.getText()) + 1;
				b.setText(""+compt);
			}
		});
		Button b1 = new Button("0");
		b1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				int compt = Integer.parseInt(b1.getText()) + 1;
				b1.setText(""+compt);
			}
		});
		Button b2 = new Button("0");
		b2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				int compt = Integer.parseInt(b2.getText()) + 1;
				b2.setText(""+compt);
			}
		});
		HBox box = new HBox(b, b1, b2); 
		Scene scene = new Scene(box);
		stage.setScene(scene);
		stage.show();
	}

	public static void main (String[] args) {
		launch(args);
	}
}
