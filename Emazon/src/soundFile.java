import java.io.File;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class soundFile extends Application {

	  public static void main(String[] args) {
	    launch(args);
	  }

	  @Override
	  public void start(Stage primaryStage) {
	    Media media = new Media("file://test.mp3");
	    MediaPlayer mediaPlayer = new MediaPlayer(media);
	    mediaPlayer.play();

	    primaryStage.setTitle("Audio Player 1");
	    primaryStage.setWidth(200);
	    primaryStage.setHeight(200);
	    primaryStage.show();
	  }
	}

