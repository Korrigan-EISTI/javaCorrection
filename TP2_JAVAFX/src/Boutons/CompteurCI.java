package Boutons;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.*;
import javafx.scene.layout.HBox;

public class CompteurCI extends Application{
	public void start(Stage stage){
		Button b = new Button("0");
		b.setOnAction(new ActionCompteur());
		Button b1 = new Button("0");
		b1.setOnAction(new ActionCompteur());
		Button b2 = new Button("0");
		b2.setOnAction(new ActionCompteur());
		HBox box = new HBox(b, b1, b2); 
		Scene scene = new Scene(box);
		stage.setScene(scene);
		stage.show();
	}
	
	public class ActionCompteur implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			int compt = Integer.parseInt(((Button)e.getSource()).getText()) + 1;
			((Button)e.getSource()).setText(""+compt);
		}
	}

	public static void main (String[] args) {
		launch(args);
	}
}
