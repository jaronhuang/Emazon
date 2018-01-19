import javafx.scene.media.Media;

public class Audiobooks {

	public class Main extends Application {

	    @Override
	    public void start(Stage primaryStage)
	    {
	        //Add a scene
	        Group root = new Group();
	        Scene scene = new Scene(root, 500, 200);

	        Media pick = new Media("put.mp3");
	        MediaPlayer player = new MediaPlayer(pick);
	        player.play();

	        //Add a mediaView, to display the media. Its necessary !
	        //This mediaView is added to a Pane
	        MediaView mediaView = new MediaView(player);
	        ((Group)scene.getRoot()).getChildren().add(mediaView);

	        //show the stage
	        primaryStage.setTitle("Media Player");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }
	    public static void main(String[] args) {
	         launch(args);
	    }
	}
}
