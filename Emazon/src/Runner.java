//import java.awt.Label;
import javafx.scene.control.Label;
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;


public class Runner extends Application { 
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Runner runner = new Runner();
		
		primaryStage.setTitle("Emazon");
		
		Button shoppingCartButton = new Button("Cart");
		//shoppingCartButton.setTranslateY(30);
		shoppingCartButton.setStyle("-fx-background-color: #ffffff; -fx-border-width: 5px; -fx-border-color: #cc0000");
		
		Button carsButton = new Button("Cars");
		//carsButton.setTranslateX(-200);
		carsButton.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		//carsButton.
		
		Button audioBookButton = new Button("Audio Books");
		//audioBookButton.setTranslateX(-100);
		audioBookButton.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		
		Button technology = new Button("Technology");
		technology.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		
		Button clothing = new Button("Clothing");
		//clothing.setTranslateX(100);
		clothing.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		
		Button shoes = new Button("Shoes");
		//shoes.setTranslateX(200);
		shoes.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		
		Button dummy = new Button("DUMMY");
		
		
		shoppingCartButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	
		    }
		});
		VBox homePage = new VBox();
		technology.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	homePage.getChildren().clear();
		    	Label technologyLabel = new Label("Technology");
		    	homePage.getChildren().add(technologyLabel);
		    	
		  }
		});
		audioBookButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	homePage.getChildren().clear();
		    	Label audioBookLabel = new Label("Audio Book");
		    	homePage.getChildren().add(audioBookLabel);
		    	
		  }
		});
		clothing.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	homePage.getChildren().clear();
		    	Label clothingLabel = new Label("Clothing");
		    	homePage.getChildren().add(clothingLabel);
		    	
		  }
		});
		carsButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	homePage.getChildren().clear();
		    	Label carsLabel = new Label("Cars");
		    	homePage.getChildren().add(carsLabel);
		    	
		  }
		});
		shoes.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	homePage.getChildren().clear();
		    	Label shoesLabel = new Label("Shoes");
		    	homePage.getChildren().add(shoesLabel);
		    	
		  }
		});
		
		FileInputStream input = new FileInputStream("earth.png");
		Image image = new Image(input);
		ImageView imageView = new ImageView(image);
		Label label = new Label("image", imageView);
		
	/*	
		StackPane stack = new StackPane();
		stack.getChildren().add(shoppingCartButton);
		stack.getChildren().add(carsButton);
		stack.getChildren().add(audioBookButton);
		stack.getChildren().add(technology);
		stack.getChildren().add(clothing);
		stack.getChildren().add(shoes);
	*/
		
		TilePane tile = new TilePane(Orientation.HORIZONTAL);
		tile.setPadding(new Insets(0, 0, 0, 0));
		tile.setHgap(10.0);
		tile.setVgap(8.0);
		
		clothing.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		carsButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		audioBookButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		technology.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		shoes.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		tile.getChildren().add(shoppingCartButton);
		tile.getChildren().add(carsButton);
		tile.getChildren().add(audioBookButton);
		tile.getChildren().add(technology);
		tile.getChildren().add(clothing);
		tile.getChildren().add(shoes);
		
	    VBox root = new VBox();
	    root.setPrefWidth(200);
	    technology.setMinWidth(root.getPrefWidth());
	    carsButton.setMinWidth(root.getPrefWidth());
		
		homePage.setStyle("-fx-border-color: #00cc00; -fx-border-width: 5px;");
		homePage.setPrefHeight(700);
		homePage.setPrefWidth(200);
		homePage.getChildren().add(dummy);
		homePage.getChildren().add(label);
		
	    root.setSpacing(50);
	    root.getChildren().add(tile);
	    root.getChildren().add(homePage);
        Scene scene = new Scene(root, 450, 700);
        primaryStage.setTitle("Emazon");
	    primaryStage.setScene(scene);
	    primaryStage.show();
		
	}
	
	
}
