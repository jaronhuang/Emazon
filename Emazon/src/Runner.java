
/**
 * By: Jaron Huang, Jefferson Bernard, Edward Yaroslavsky, Muhammad Usman, Kelvin Chen
 */


import javafx.scene.control.Label;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;


public class Runner extends Application { 
	
	
	public static void main(String[] args) throws IOException {
 		Application.launch(args);

		File inventory = new File("inventory.csv");
		
		CSVUtilities inv = new CSVUtilities(inventory);
		
		File cart = new File("cart.csv");
		CSVUtilities kart = new CSVUtilities(cart);
	
		File purchase = new File("phistory.csv");
		CSVUtilities history = new CSVUtilities(purchase);		
 	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Runner runner = new Runner();
		
		primaryStage.setTitle("Emazon");
		
		Button shoppingCartButton = new Button("Cart");
		shoppingCartButton.setStyle("-fx-background-color: #ffffff; -fx-border-width: 5px; -fx-border-color: #cc0000");
		
		Button carsButton = new Button("Cars");
		carsButton.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		
		Button audioBookButton = new Button("Audio Books");
		audioBookButton.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		
		Button technology = new Button("Technology");
		technology.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		
		Button clothing = new Button("Clothing");
		clothing.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		
		Button shoes = new Button("Shoes");
		shoes.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		
		
		
		
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
		    	
/*		    	FileInputStream input = new FileInputStream("earth.png");
				Image image = new Image(input);
				ImageView imageView = new ImageView(image);
				imageView.setFitHeight(400);
				imageView.setFitWidth(400);
				imageView.setTranslateX(20);
				homePage.getChildren().add(imageView); */
		    	
/*		    	FileInputStream tech = new FileInputStream("");
		    	Image techImage = new Image(tech);
		    	ImageView techImageView = new ImageView(techImage); */
		    	
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

		/*
		 * TilePane for the row of buttons that lead to other pages.
		 * Uses setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE) to automatically even out widths of buttons horizontally.
		 */
		clothing.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		carsButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		audioBookButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		technology.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		shoes.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		TilePane tile = new TilePane(Orientation.HORIZONTAL);
		tile.setPadding(new Insets(20, 10, 20, 0));
		tile.setHgap(0.0);
		tile.setVgap(8.0);
		
		tile.getChildren().add(shoes);
		tile.getChildren().add(carsButton);
		tile.getChildren().add(audioBookButton);
		tile.getChildren().add(technology);
		tile.getChildren().add(clothing);
		tile.getChildren().add(shoppingCartButton);
		shoppingCartButton.setTranslateX(173);
		
	    	VBox root = new VBox();
	   	//root.setPrefWidth(200);
		
		homePage.setStyle("-fx-border-color: #00cc00; -fx-border-width: 5px;");
		homePage.setPrefHeight(700);
		homePage.setPrefWidth(200);
		
		FileInputStream input = new FileInputStream("earth.png");
		Image image = new Image(input);
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(400);
		imageView.setFitWidth(400);
		imageView.setTranslateX(20);
		homePage.getChildren().add(imageView);
		
		Text homeText = new Text("EmaZon: Making Shopping EZ");
		homeText.setFont(Font.font("Comic Sans",FontPosture.ITALIC,24));
		homeText.setFill(Color.BLUEVIOLET);
		homeText.setTranslateX(70);
		homeText.setTranslateY(50);
		homePage.getChildren().add(homeText);
		
	    //root.setSpacing(50);
	    root.getChildren().add(tile);
	    root.getChildren().add(homePage);
        Scene scene = new Scene(root, 450, 700);
        primaryStage.setTitle("Emazon");
	    primaryStage.setScene(scene);
	    primaryStage.show();
		
	}
	
	
}
