/**
 * By: Jaron Huang and Kelvin Chen

 */
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.geometry.HPos;
import javafx.geometry.Insets;

public class Audiobooks implements Items {

	public double price;
	public int quantity;
	public String name;
	public double rating;
	public String soundFile;
	public int length;


	
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
