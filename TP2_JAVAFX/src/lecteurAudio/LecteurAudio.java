package lecteurAudio;

import java.io.File;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.FileChooser;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class LecteurAudio extends Application{
	public void start (Stage st) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Music", "*.mp3"));
		Button play = new Button("Play");
		Button reverse = new Button("<<<<");
		Slider slider =  new Slider(0,100,50);
		slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
		slider.setBlockIncrement(10);
		File file = fileChooser.showOpenDialog(st);
		if (file == null) {
			System.exit(-1);
		}
		Media media = new Media(file.toURI().toString());
		MediaPlayer player = new MediaPlayer(media);
		play.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (play.getText() == "Play") {
					player.play();
					play.setText("Pause");
				}else {
					player.pause();
					play.setText("Play");
				}
			}
		});
		reverse.setOnAction(e-> player.seek(Duration.ZERO));
		Slider avance = new Slider();
		avance.setShowTickMarks(true);
		EventHandler<MouseEvent> onClickAndOnDragHandler =
		e -> {
			player.seek(player.getMedia().getDuration().multiply(e.getX() / avance.getWidth()));
			e.consume();
		};
		avance.addEventHandler(MouseEvent.MOUSE_CLICKED, onClickAndOnDragHandler);
		avance.addEventHandler(MouseEvent.MOUSE_DRAGGED, onClickAndOnDragHandler);
		player.volumeProperty().bind(slider.valueProperty().divide(100));
		HBox box = new HBox(play, reverse, slider, avance);
		Scene scene = new Scene(box);
		st.setScene(scene);
		st.show();
	}
	
	public static void main (String[] args) {
		launch(args);
	}
}
