/**
 * By: Jaron Huang and Kelvin Chen
 */
import javafx.scene.media.Media;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.geometry.HPos;
import javafx.geometry.Insets;

public class Audiobooks implements Items{

	public double price;
	public int quantity;
	public String name;
	public double rating;
	public String soundFile;
	public int length;

	/*public class Main extends Application {

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
	}*/
	public Audiobooks(double price, int quantity, String name,
			double rating, String soundFile, int length)
	{
		this.price = price;
		this.quantity = quantity;
		this.name = name;
		this.rating = rating;
		this.soundFile = soundFile;
		this.length = length;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getName() {
		return name;
	}
	public double getRating() {
		return rating;
	}
	public String getSoundFile() {
		return soundFile;
	}
	public int getLength() {
		return length;
	}
	
}
