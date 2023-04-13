package canvas;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class PointsARelier extends Application{
	public void start (Stage st) {
		Canvas csgo = new Canvas(500, 500);
		Button pap = new Button("Relier les points pas à pas");
		Button p = new Button("Relier tous les points");
		BorderPane BP = new BorderPane();
		HBox hb = new HBox(pap, p);
		BP.setCenter(csgo);
		BP.setBottom(hb);
		Scene sc = new Scene(BP);
		st.setScene(sc);
		st.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
