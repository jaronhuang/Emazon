/**
 * By: Jaron Huang, Jefferson Bernard, Edward Yaroslavsky, Muhammad Usman, Kelvin Chen
 */


import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
	//ARRAY LISTS CONTAINING EACH INFORMATION FROM EACH COLUMN IN THE INVENTORY.
	static ArrayList<String> itemNames = new ArrayList<String>();
	static ArrayList<Integer> quantity = new ArrayList<Integer>();
	static ArrayList<Double> price = new ArrayList<Double>();
	static ArrayList<Double> rating = new ArrayList<Double>();
	static ArrayList<String> model = new ArrayList<String>();
	static ArrayList<String> color = new ArrayList<String>();
	static ArrayList<Double> size = new ArrayList<Double>();
	static ArrayList<String> type = new ArrayList<String>();
	static ArrayList<Double> batteryLife = new ArrayList<Double>();
	static ArrayList<Double> mileage = new ArrayList<Double>();
	static ArrayList<Integer> length = new ArrayList<Integer>();
	static ArrayList<String> audioFile = new ArrayList<String>();
	static ArrayList<String> imageFiles = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		//INVENTORY FILE
		File inventory = new File("inventory.csv");
		CSVUtilities inv = new CSVUtilities(inventory);
		itemNames = inv.getDataString(0);
		quantity = inv.getDataInteger(1);
		price = inv.getDataDouble(2);
		rating = inv.getDataDouble(3);
		model = inv.getDataString(4);
		color = inv.getDataString(5);
		size = inv.getDataDouble(6);
		type = inv.getDataString(7);
		batteryLife = inv.getDataDouble(8);
		mileage = inv.getDataDouble(9);
		length = inv.getDataInteger(10);
		audioFile = inv.getDataString(11);
		imageFiles = inv.getDataString(12);
		
		//CART FILE
		File cart = new File("cart.csv");
		CSVUtilities kart = new CSVUtilities(cart);
	
		//PURCHASE HISTORY FILE
		File purchase = new File("phistory.csv");
		CSVUtilities history = new CSVUtilities(purchase);	
		
		Application.launch(args);
 	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Runner runner = new Runner();
		primaryStage.setTitle("Emazon");
		VBox homePage = new VBox();
		
		//CARS BUTTON
	   
		Button carsButton = new Button("Cars");// do the same for each category
		FileInputStream  carImage = new FileInputStream("car.png") ; //
		Image imageCar = new Image(carImage) ;//
		ImageView imageCarView = new ImageView(imageCar) ;//
		imageCarView.setFitHeight(40);//
		imageCarView.setFitWidth(40) ; //
     
		carsButton.setGraphic(imageCarView);//
		carsButton.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		carsButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	homePage.getChildren().clear();
		    	Label carsLabel = new Label("Cars");
		    	homePage.getChildren().add(carsLabel);
		    	
		    	FileInputStream input = null;
				try {
					input = new FileInputStream(imageFiles.get(1));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Image image = new Image(input);
				ImageView imageView = new ImageView(image);
				imageView.setFitHeight(400);
				imageView.setFitWidth(400);
				imageView.setTranslateX(20);
				homePage.getChildren().add(imageView);
		    	
				Label carPrice = new Label(""+price.get(1));
				homePage.getChildren().add(carPrice);
		  }
		});
		
		//AUDIO BOOK BUTTON
		Button audioBookButton = new Button("Audio Books");
		FileInputStream  audioImage = new FileInputStream("audiobooks.png") ; //
		Image imageAudio = new Image(audioImage) ;//
		ImageView imageAudioView = new ImageView(imageAudio) ;//
		imageAudioView.setFitHeight(40);//
		imageAudioView.setFitWidth(40) ; //
     
		audioBookButton.setGraphic(imageAudioView);//
		audioBookButton.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		audioBookButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	homePage.getChildren().clear();
		    	Label audioBookLabel = new Label("Audio Book");
		    	homePage.getChildren().add(audioBookLabel);
		    	
		    	FileInputStream input = null;
				try {
					input = new FileInputStream(imageFiles.get(0));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Image image = new Image(input);
				ImageView imageView = new ImageView(image);
				imageView.setFitHeight(400);
				imageView.setFitWidth(400);
				imageView.setTranslateX(20);
				homePage.getChildren().add(imageView);
				
				Label bookPrice = new Label(""+price.get(0));
				homePage.getChildren().add(bookPrice);
		    
		    	
		  }
		});
		
		//TECHNOLOGY BUTTON
		Button technology = new Button("Technology");
		FileInputStream  techImage = new FileInputStream("tech icon.png") ; //
		Image imageTech = new Image(techImage) ;//
		ImageView imageTechView = new ImageView(imageTech) ;//
		imageTechView.setFitHeight(40);//
		imageTechView.setFitWidth(40) ; //
     
		technology.setGraphic(imageTechView);//
		technology.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		technology.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	homePage.getChildren().clear();
		    	Label technologyLabel = new Label("Technology");
		    	homePage.getChildren().add(technologyLabel);
		    	
		    	FileInputStream input = null;
				try {
					input = new FileInputStream(imageFiles.get(4));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Image image = new Image(input);
				ImageView imageView = new ImageView(image);
				imageView.setFitHeight(400);
				imageView.setFitWidth(400);
				imageView.setTranslateX(20);
				homePage.getChildren().add(imageView);
				
				Label techPrice = new Label(""+price.get(4));
				homePage.getChildren().add(techPrice);
		  }
		});
		
		//CLOTHING BUTTON
		Button clothing = new Button("Clothing");
		FileInputStream  clothingImage = new FileInputStream("shirts.png") ; //
		Image imageClothes = new Image(clothingImage) ;//
		ImageView imageClothesView = new ImageView(imageClothes) ;//
		imageClothesView.setFitHeight(40);//
		imageClothesView.setFitWidth(40) ; //
     
		clothing.setGraphic(imageClothesView);//
		clothing.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		clothing.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	homePage.getChildren().clear();
		    	Label clothingLabel = new Label("Clothing");
		    	homePage.getChildren().add(clothingLabel);
		    	
		    	FileInputStream input = null;
				try {
					input = new FileInputStream(imageFiles.get(2));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Image image = new Image(input);
				ImageView imageView = new ImageView(image);
				imageView.setFitHeight(400);
				imageView.setFitWidth(400);
				imageView.setTranslateX(20);
				homePage.getChildren().add(imageView);
		    	
				Label clothPrice = new Label(""+price.get(2));
				homePage.getChildren().add(clothPrice);
		  }
		});
		
		//SHOES BUTTON
		Button shoes = new Button("Shoes");
		FileInputStream  shoesImage = new FileInputStream("shoes.png") ; //
		Image imageShoes = new Image(shoesImage) ;//
		ImageView imageShoesView = new ImageView(imageShoes) ;//
		imageShoesView.setFitHeight(40);//
		imageShoesView.setFitWidth(40) ; //
		shoes.setGraphic(imageShoesView);//
		shoes.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		shoes.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	homePage.getChildren().clear();
		    	Label shoesLabel = new Label("Shoes");
		    	homePage.getChildren().add(shoesLabel);
		    	
		    	FileInputStream input = null;
				try {
					input = new FileInputStream(imageFiles.get(3));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Image image = new Image(input);
				ImageView imageView = new ImageView(image);
				imageView.setFitHeight(400);
				imageView.setFitWidth(400);
				imageView.setTranslateX(20);
				homePage.getChildren().add(imageView);
		    	
				Label shoePrice = new Label(""+price.get(3));
				homePage.getChildren().add(shoePrice);
		  }
		});
		
		//SHOPPING CART AND CHECKOUT
		Button shoppingCartButton = new Button("Cart");
		shoppingCartButton.setStyle("-fx-background-color: #ffffff; -fx-border-width: 5px; -fx-border-color: #cc0000");
		shoppingCartButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	homePage.getChildren().clear();
		    	Label shoppingCartLabel = new Label("Shopping Cart");
		    	homePage.getChildren().add(shoppingCartLabel);
		    	
		    	Button checkoutButton = new Button("Checkout");
		    	checkoutButton.setStyle("-fx-background-color: #ffffff; -fx-border-width: 5px; -fx-border-color: #cc0000");
		    	
		    	homePage.getChildren().add(checkoutButton);
		    	checkoutButton.setOnAction(new EventHandler<ActionEvent>() 
		    	{
		    		@Override
		    		public void handle(ActionEvent event) {
		    			homePage.getChildren().clear();
		    			Label checkoutLabel = new Label("Checkout");
		    			homePage.getChildren().add(checkoutLabel);
				    	
		    			Label checkoutName = new Label("Name:");
		    			TextField name = new TextField();
		    			name.setMaxSize(250, 20);
		    			name.setPromptText("Enter your name here.");
		    			homePage.getChildren().addAll(checkoutName, name);			    	
		    			Label checkoutAddress = new Label("Address:");
		    			TextField address = new TextField();
		    			address.setMaxSize(250, 20);
		    			address.setPromptText("Enter your address here.");
		    			homePage.getChildren().addAll(checkoutAddress, address);
				    	
		    			Label checkoutEmail = new Label("Email:");
		    			TextField email = new TextField();
		    			email.setMaxSize(250, 20);
		    			email.setPromptText("Enter your email here.");
		    			homePage.getChildren().addAll(checkoutEmail, email);
				    	
		    			Label checkoutCard = new Label("Card #:");
		    			TextField card = new TextField();
		    			card.setMaxSize(250, 20);
		    			card.setPromptText("Enter your card number here.");
		    			homePage.getChildren().addAll(checkoutCard, card);
				    	
		    			Label checkoutExpiration = new Label("EXP. Date:");
		    			TextField expiration = new TextField();
		    			expiration.setMaxSize(250, 20);
						expiration.setPromptText("Enter your expiration date here.");
						homePage.getChildren().addAll(checkoutExpiration, expiration);
						    	
						Button payButton = new Button("Pay & Ship");
						payButton.setStyle("-fx-background-color: #ffffff; -fx-border-width: 5px; -fx-border-color: #cc0000");
						payButton.setTranslateY(10);
						homePage.getChildren().add(payButton);
						    
						Text CheckoutNameError = new Text("*Enter all the required fields*");
						
						payButton.setOnAction(new EventHandler<ActionEvent>() 
						{
							@Override
							public void handle(ActionEvent event) {
								homePage.getChildren().remove(CheckoutNameError);
								if (name.getCharacters().length() == 0 || address.getCharacters().length() == 0
									|| email.getCharacters().length() == 0 || card.getCharacters().length() == 0
									|| expiration.getCharacters().length() == 0) {
								    CheckoutNameError.setFont(Font.font("Comic Sans",FontPosture.ITALIC,14));
								    CheckoutNameError.setFill(Color.RED);
								    CheckoutNameError.setTranslateY(25);
								    homePage.getChildren().add(CheckoutNameError);
								}	
								else
								{
									homePage.getChildren().clear();
										    	
									Text thanks = new Text("Thank you for shopping with Emazon!" 
											    		+ "\nYou are a highly valued customer!");
									thanks.setFont(Font.font("Comic Sans",FontPosture.ITALIC,24));
									thanks.setFill(Color.BLUEVIOLET);
									thanks.setTranslateX(25);
									thanks.setTranslateY(50);
									homePage.getChildren().add(thanks);
											    	
									FileInputStream input = null;
									try {
										input = new FileInputStream("thumbsUp.png");
									} 
									catch (FileNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									Image image = new Image(input);
									ImageView imageView = new ImageView(image);
									imageView.setFitHeight(400);
									imageView.setFitWidth(400);
									imageView.setTranslateX(-50);
									imageView.setTranslateY(70);
									homePage.getChildren().add(imageView);
								}
							}
						});  
		    		}
		    	});
			    	
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
//		shoppingCartButton.setTranslateX(173);
		
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
