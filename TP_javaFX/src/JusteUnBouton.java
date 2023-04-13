
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class JusteUnBouton extends Application{
	public void start(Stage stage) {
		stage.setTitle("Juste un Bouton");
		Button btn = new Button("Clique moi");
		btn.setId("unpressed");
		Scene scene = new Scene(btn);
		scene.getStylesheets().add("style.css");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main (String[] args) {
		launch(args);
	}
}
