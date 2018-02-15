/**
 * By: Jaron Huang, Jefferson Bernard, Edward Yaroslavsky, Muhammad Usman, Kelvin Chen
 */


import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
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
	static ArrayList<String> size = new ArrayList<String>();
	static ArrayList<String> type = new ArrayList<String>();
	static ArrayList<Double> batteryLife = new ArrayList<Double>();
	static ArrayList<Double> mileage = new ArrayList<Double>();
	static ArrayList<String> length = new ArrayList<String>();
	static ArrayList<String> audioFile = new ArrayList<String>();
	static ArrayList<String> imageFiles = new ArrayList<String>();
	
	static ArrayList<String> cartImageFiles = new ArrayList<String>();
	static ArrayList<Double> cartPrices = new ArrayList<Double>();
	static ArrayList<String> cartNames = new ArrayList<String>();
	static ArrayList<ArrayList<String>> cartPages = new ArrayList<ArrayList<String>>();
	static ArrayList<Button> cartPageButtonArrayList = new ArrayList<Button>();
	
	public static ArrayList<Cars> carsArrayList = new ArrayList<Cars>();
	public static ArrayList<Songs> songsArrayList = new ArrayList<Songs>();
	public static ArrayList<Technology> technologyArrayList = new ArrayList<Technology>();
	public static ArrayList<Hair> hairArrayList = new ArrayList<Hair>();
	public static ArrayList<Accessories> accessArrayList = new ArrayList<Accessories>();
	
	
	static CSVUtilities kart = null;
	
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
		size = inv.getDataString(6);
		type = inv.getDataString(7);
		batteryLife = inv.getDataDouble(8);
		mileage = inv.getDataDouble(9);
		length = inv.getDataString(10);
		audioFile = inv.getDataString(11);
		imageFiles = inv.getDataString(12);
		
		//CART FILE
		File cart = new File("cart.csv");
		kart = new CSVUtilities(cart);	
		
		for (int i=0; i<kart.getCSVData().size(); i++)
		{
			System.out.print(kart.getCSVData().get(i)+", ");
		}
		System.out.println(""+kart.getCSVData().size());
		if (kart.getCSVData().size()!=5)
		{
			cartImageFiles = kart.getDataString(3);
			cartPrices = kart.getDataDouble(2);
			cartNames = kart.getDataString(0);
		}
		
		//PURCHASE HISTORY FILE
		File purchase = new File("phistory.csv");
		CSVUtilities history = new CSVUtilities(purchase);
		
		//GENERATING CARS
		Cars lameloLambo = new Cars(2);
		carsArrayList.add(lameloLambo);
		Cars liangeloRari = new Cars(3);
		carsArrayList.add(liangeloRari);
		Cars lonzoG = new Cars(4);
		carsArrayList.add(lonzoG);
		Cars lavarRoll = new Cars(5);
		carsArrayList.add(lavarRoll);
		
		//GENERATING MUSIC
		Songs superSaiyan = new Songs(0);
		songsArrayList.add(superSaiyan);
		Songs getOff = new Songs(1);
		songsArrayList.add(getOff);
		
		//GENERATE TECHNOLOGY
		Technology bPhone8 = new Technology(6);
		technologyArrayList.add(bPhone8);
		Technology bPhoneX = new Technology(7);
		technologyArrayList.add(bPhoneX);
		
		//GENERATE HAIR
		Hair lameloHair = new Hair(9);
		hairArrayList.add(lameloHair);
		Hair geloHair = new Hair(8);
		hairArrayList.add(geloHair);
		Hair lonzoHair = new Hair(10);
		hairArrayList.add(lonzoHair);
		Hair lavarHair = new Hair(11);
		hairArrayList.add(lavarHair);
		
		//GENERATE ACCESSORIES
		Accessories fannyPack = new Accessories(12);
		accessArrayList.add(fannyPack);
		Accessories chain = new Accessories(13);
		accessArrayList.add(chain);
		Accessories wallet = new Accessories(14);
		accessArrayList.add(wallet);
		
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Runner runner = new Runner();
		primaryStage.setTitle("Emazon");
		VBox homePage = new VBox();
		
		//CARS BUTTON
		Button carsButton = new Button("");// do the same for each category
		FileInputStream  carImage = new FileInputStream("car.png") ; //
		Image imageCar = new Image(carImage) ;//
		ImageView imageCarView = new ImageView(imageCar) ;//
		imageCarView.setFitHeight(35);//
		imageCarView.setFitWidth(35) ; //
     
		carsButton.setGraphic(imageCarView);//
		carsButton.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		carsButton.setTranslateX(5);
		carsButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	homePage.getChildren().clear();
		    	Label carsLabel = new Label("Cars");
		    	carsLabel.setFont(Font.font("Comic Sans",FontWeight.BOLD,20));
		    	carsLabel.setTranslateX(185);

		    	
		    	homePage.getChildren().add(carsLabel);
		  
		    	for (int i=0; i<carsArrayList.size(); i++)
		    	{
		    		Cars tempCar = carsArrayList.get(i);
		    		Label carName = new Label(tempCar.getName());
					homePage.getChildren().add(carName);
					carName.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));
		    		FileInputStream input = null;
		    		try {
					input = new FileInputStream(tempCar.getImage());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Image image = new Image(input);
					ImageView imageView = new ImageView(image);
					imageView.setFitHeight(150);
					imageView.setFitWidth(150);
					homePage.getChildren().add(imageView);
					imageView.onMouseEnteredProperty();
					
					
					Label carPrice = new Label("$"+tempCar.getPrice());
					homePage.getChildren().add(carPrice);
					carPrice.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));

					Label carColor = new Label(tempCar.getColor());
					homePage.getChildren().add(carColor);
					carColor.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));

					Label carMlg = new Label(tempCar.getMilage() + "miles per gallon");
					homePage.getChildren().add(carMlg);
					carMlg.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));

					Label carRate = new Label(tempCar.getRating() + " / 5.0");
					homePage.getChildren().add(carRate);
					carRate.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));
					
					Button addToCart = new Button("ADD TO CART");
					addToCart.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
							CSVUtilities.writeCSV(tempCar.getName(), 1, tempCar.getPrice(),tempCar.getImage());
							cartImageFiles.add(tempCar.getImage());
							cartPrices.add(tempCar.getPrice());
							cartNames.add(tempCar.getName());
						}
					});
					homePage.getChildren().add(addToCart);

					if (i==0)
					{
						settingItemTranslates(imageView, carName, carPrice, carColor, carColor, carMlg, carRate, addToCart, addToCart, 20, 24);
					}
					
					else if (i==1)
					{
						settingItemTranslates(imageView, carName, carPrice, carColor, carColor, carMlg, carRate, addToCart, addToCart, 20, 50);
					}
					
					else if (i==2)
					{
						settingItemTranslates(imageView, carName, carPrice, carColor, carColor, carMlg, carRate, addToCart, addToCart, 250, -548);
					}
					
					else if (i==3)
					{
						settingItemTranslates(imageView, carName, carPrice, carColor, carColor, carMlg, carRate, addToCart, addToCart, 250, -523);
						
					}
		/*			JButton jbuttonImg = new JButton();
					jbuttonImg.setIcon(new ImageIcon(tempCar.getName()));
					jbuttonImg.addMouseListener(new MouseListener() {

						@Override
						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							jbuttonImg.setIcon(new ImageIcon("lamelolambo.jpg"));
						}

						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							jbuttonImg.setIcon(new ImageIcon(tempCar.getName()));
						}

						@Override
						public void mousePressed(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						
					});
			    	*/					
		    	} 

		    	homePage.setPadding(new Insets(0,0,-500,0)); // This is for the border problem

		  }
		});
		
		//MUSIC BUTTON
		Button musicButton = new Button("");
		FileInputStream  audioImage = new FileInputStream("music1.png") ; 
		Image imageAudio = new Image(audioImage) ;
		ImageView imageAudioView = new ImageView(imageAudio) ;
		imageAudioView.setFitHeight(40);
		imageAudioView.setFitWidth(40) ; 
     
		musicButton.setGraphic(imageAudioView);
		musicButton.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		
		musicButton.setTranslateX(5);
		musicButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	homePage.getChildren().clear();
		    	Label audioBookLabel = new Label("Music");
		    	
		    	audioBookLabel.setFont(Font.font("Comic Sans",FontWeight.BOLD,20));
		    	audioBookLabel.setTranslateX(185);
		    	
		    	homePage.getChildren().add(audioBookLabel);
		    	
		    	for (int i=0; i<songsArrayList.size(); i++)
		    	{
		    		Songs tempSong = songsArrayList.get(i);
		    		Label songName = new Label(tempSong.getName());
					homePage.getChildren().add(songName);
					songName.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));
		    		FileInputStream input = null;
		    		try {
					input = new FileInputStream(tempSong.getImage());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Image image = new Image(input);
					ImageView imageView = new ImageView(image);
					imageView.setFitHeight(150);
					imageView.setFitWidth(150);
					homePage.getChildren().add(imageView);
					imageView.onMouseEnteredProperty();
					
					Label songPrice = new Label("$"+tempSong.getPrice());
					homePage.getChildren().add(songPrice);
					songPrice.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));

					Label songLength = new Label(tempSong.getLength());
					homePage.getChildren().add(songLength);
					songLength.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));

					Label songRate = new Label(tempSong.getRating() + " / 5.0");
					homePage.getChildren().add(songRate);
					songRate.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));
					
					Button playButton = new Button("play");
				
					playButton.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					  public void handle(ActionEvent event) {
						  String bip = tempSong.getSoundFile();
						  Media hit = new Media(new File(bip).toURI().toString());
						  MediaPlayer mediaPlayer = new MediaPlayer(hit);
						  mediaPlayer.play();
						  Button stopButton = new Button("stop");
						  stopButton.setTranslateX(300);
						  stopButton.setTranslateY(-300);
						  stopButton.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent arg0) {
								mediaPlayer.stop();
								homePage.getChildren().remove(stopButton);
							}
						  });
						  homePage.getChildren().add(stopButton);
						}
					});
					homePage.getChildren().add(playButton);
					
					Button addToCart = new Button("ADD TO CART");
					addToCart.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
							CSVUtilities.writeCSV(tempSong.getName(), 1, tempSong.getPrice(),tempSong.getImage());
							cartImageFiles.add(tempSong.getImage());
							cartPrices.add(tempSong.getPrice());
							cartNames.add(tempSong.getName());
						}
					});
					homePage.getChildren().add(addToCart);

					if (i==0)
					{
						settingItemTranslates(imageView, songName, songPrice, songLength, songRate, songRate, songRate, addToCart, playButton, 20, 24);
					}
					
					else if (i==1)
					{
						settingItemTranslates(imageView, songName, songPrice, songLength, songRate, songRate, songRate, addToCart, playButton, 20, 24);
					}
					
					else if (i==2)
					{
						settingItemTranslates(imageView, songName, songPrice, songLength, songRate, songRate, songRate, addToCart, playButton, 20, 24);
					}
					
					else if (i==3)
					{
						settingItemTranslates(imageView, songName, songPrice, songLength, songRate, songRate, songRate, addToCart, playButton, 20, 24);
						
					}
		    	}	   
		    	FileInputStream input = null;
				try {
					input = new FileInputStream("lonzo.gif");
				} 
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Image image = new Image(input);
				ImageView imageView = new ImageView(image);
				imageView.setFitHeight(200);
				imageView.setFitWidth(200);
				imageView.setTranslateX(200);
				imageView.setTranslateY(-400);
				homePage.getChildren().add(imageView);
		    	homePage.setPadding(new Insets(0,0,-500,0)); // This is for the border problem
		    } 
		}); 
		
		//TECHNOLOGY BUTTON
		Button technology = new Button("");
		FileInputStream  techImage = new FileInputStream("smartphone.png") ; //
		Image imageTech = new Image(techImage) ;//
		ImageView imageTechView = new ImageView(imageTech) ;//
		imageTechView.setFitHeight(35);//
		imageTechView.setFitWidth(35) ; //
     
		technology.setGraphic(imageTechView);//
		technology.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		technology.setTranslateX(5);
		technology.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	homePage.getChildren().clear();
		    	Label technologyLabel = new Label("Technology");

		    	technologyLabel.setFont(Font.font("Comic Sans",FontWeight.BOLD,20));
		    	technologyLabel.setTranslateX(165);

		    	homePage.getChildren().add(technologyLabel);
		    	
		    	for (int i=0; i<technologyArrayList.size(); i++)
		    	{
		    		Technology tempTech = technologyArrayList.get(i);
		    		Label techName = new Label(tempTech.getName());
					homePage.getChildren().add(techName);
					techName.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));
		    		FileInputStream input = null;
		    		try {
					input = new FileInputStream(tempTech.getImage());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Image image = new Image(input);
					ImageView imageView = new ImageView(image);
					imageView.setFitHeight(150);
					imageView.setFitWidth(150);
					homePage.getChildren().add(imageView);
					
					Label techPrice = new Label("$"+tempTech.getPrice());
					homePage.getChildren().add(techPrice);
					techPrice.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));

					Label techBLife = new Label(""+tempTech.getBatteryLife());
					homePage.getChildren().add(techBLife);
					techBLife.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));

					Label techRate = new Label(tempTech.getRating() + " / 5.0");
					homePage.getChildren().add(techRate);
					techRate.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));
					
					Button addToCart = new Button("ADD TO CART");
					addToCart.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
							CSVUtilities.writeCSV(tempTech.getName(), 1, tempTech.getPrice(),tempTech.getImage());
							cartImageFiles.add(tempTech.getImage());
							cartPrices.add(tempTech.getPrice());
							cartNames.add(tempTech.getName());
						}
					});
					homePage.getChildren().add(addToCart);

					if (i==0)
					{
						settingItemTranslates(imageView, techName, techPrice, techBLife, techRate, techRate, techRate, addToCart, addToCart, 20, 24);
					}
					
					else if (i==1)
					{
						settingItemTranslates(imageView, techName, techPrice, techBLife, techRate, techRate, techRate, addToCart, addToCart, 20, 40);
					}
					
					else if (i==2)
					{
						settingItemTranslates(imageView, techName, techPrice, techBLife, techRate, techRate, techRate, addToCart, addToCart, 20, 24);
					}
					
					else if (i==3)
					{
						settingItemTranslates(imageView, techName, techPrice, techBLife, techRate, techRate, techRate, addToCart, addToCart, 20, 24);
						
					}
		    	}	   
		    	
				homePage.setPadding(new Insets(0,0,-500,0)); // This is for the border problem

		  }
		});
		
		//HAIR BUTTON
		Button hair = new Button("");
		FileInputStream  clothingImage = new FileInputStream("haircut.png") ; //
		Image imageClothes = new Image(clothingImage) ;//
		ImageView imageClothesView = new ImageView(imageClothes) ;//
		imageClothesView.setFitHeight(50);//
		imageClothesView.setFitWidth(50) ; //
     
		hair.setGraphic(imageClothesView);//
		hair.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		hair.setTranslateX(5);
		hair.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	homePage.getChildren().clear();
		    	Label hairLabel = new Label("Hair");
		    	hairLabel.setFont(Font.font("Comic Sans",FontWeight.BOLD,20));
		    	hairLabel.setTranslateX(175);
		    	homePage.getChildren().add(hairLabel);
		    	
		    	for (int i=0; i<hairArrayList.size(); i++)
		    	{
		    		Hair tempHair = hairArrayList.get(i);
		    		Label hairName = new Label(tempHair.getName());
					homePage.getChildren().add(hairName);
					hairName.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));
		    		FileInputStream input = null;
		    		try {
					input = new FileInputStream(tempHair.getImage());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Image image = new Image(input);
					ImageView imageView = new ImageView(image);
					imageView.setFitHeight(150);
					imageView.setFitWidth(150);
					homePage.getChildren().add(imageView);
					
					Label hairPrice = new Label("$"+tempHair.getPrice());
					homePage.getChildren().add(hairPrice);
					hairPrice.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));

					Label hairRate = new Label(tempHair.getRating() + " / 5.0");
					homePage.getChildren().add(hairRate);
					hairRate.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));
					
					Button addToCart = new Button("ADD TO CART");
					addToCart.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
							CSVUtilities.writeCSV(tempHair.getName(), 1, tempHair.getPrice(),tempHair.getImage());
							cartImageFiles.add(tempHair.getImage());
							cartPrices.add(tempHair.getPrice());
							cartNames.add(tempHair.getName());
						}
					});
					homePage.getChildren().add(addToCart);

					if (i==0)
					{
						settingItemTranslates(imageView, hairName, hairPrice, hairRate, hairRate, hairRate, hairRate, addToCart, addToCart, 20, 24);
					}
					
					else if (i==1)
					{
						settingItemTranslates(imageView, hairName, hairPrice, hairRate, hairRate, hairRate, hairRate, addToCart, addToCart, 20, 50);
					}
					
					else if (i==2)
					{
						settingItemTranslates(imageView, hairName, hairPrice, hairRate, hairRate, hairRate, hairRate, addToCart, addToCart, 250, -466);
					}
					
					else if (i==3)
					{
						settingItemTranslates(imageView, hairName, hairPrice, hairRate, hairRate, hairRate, hairRate, addToCart, addToCart, 250, -438);
						
					}
		    	}	   
		    	
				homePage.setPadding(new Insets(0,0,-500,0)); // This is for the border problem

		  }
		});
		
		//SHOES BUTTON
		Button shoes = new Button("");

		FileInputStream  shoesImage = new FileInputStream("acc.png") ; //
		Image imageShoes = new Image(shoesImage) ;//
		ImageView imageShoesView = new ImageView(imageShoes) ;//
		imageShoesView.setFitHeight(35);//
		imageShoesView.setFitWidth(35) ; //
		shoes.setGraphic(imageShoesView);//
    
		shoes.setStyle("-fx-background-color: #ffffff; -fx-border-width: 2px; -fx-border-color: #cc00cc");
		shoes.setTranslateX(5);
		shoes.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	homePage.getChildren().clear();
		    	Label shoesLabel = new Label("Shoes");
		    	shoesLabel.setFont(Font.font("Comic Sans",FontWeight.BOLD,20));
		    	shoesLabel.setTranslateX(185);
		    	homePage.getChildren().add(shoesLabel);
		    	
		    	for (int i=0; i<accessArrayList.size(); i++)
		    	{
		    		Accessories tempAccess = accessArrayList.get(i);
		    		Label accessName = new Label(tempAccess.getName());
					homePage.getChildren().add(accessName);
					accessName.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));
		    		FileInputStream input = null;
		    		try {
					input = new FileInputStream(tempAccess.getImage());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Image image = new Image(input);
					ImageView imageView = new ImageView(image);
					imageView.setFitHeight(150);
					imageView.setFitWidth(150);
					homePage.getChildren().add(imageView);
					
					Label accessPrice = new Label("$"+tempAccess.getPrice());
					homePage.getChildren().add(accessPrice);
					accessPrice.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));

					Label accessRate = new Label(tempAccess.getRating() + " / 5.0");
					homePage.getChildren().add(accessRate);
					accessRate.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));
					
					Button addToCart = new Button("ADD TO CART");
					addToCart.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
							CSVUtilities.writeCSV(tempAccess.getName(), 1, tempAccess.getPrice(),tempAccess.getImage());
							cartImageFiles.add(tempAccess.getImage());
							cartPrices.add(tempAccess.getPrice());
							cartNames.add(tempAccess.getName());
						}
					});
					homePage.getChildren().add(addToCart);

					if (i==0)
					{
						settingItemTranslates(imageView, accessName, accessPrice, accessRate, accessRate, accessRate, accessRate, addToCart, addToCart, 20, 24);
					}
					
					else if (i==1)
					{
						settingItemTranslates(imageView, accessName, accessPrice, accessRate, accessRate, accessRate, accessRate, addToCart, addToCart, 20, 50);
					}
					
					else if (i==2)
					{
						settingItemTranslates(imageView, accessName, accessPrice, accessRate, accessRate, accessRate, accessRate, addToCart, addToCart, 250, -466);
					}
					
					else if (i==3)
					{
						settingItemTranslates(imageView, accessName, accessPrice, accessRate, accessRate, accessRate, accessRate, addToCart, addToCart, 20, 24);
						
					}
		    	}	   
		    	
		   /* 	FileInputStream input = null;
				try {
					input = new FileInputStream(imageFiles.get(3));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Image image = new Image(input);
				ImageView imageView = new ImageView(image);
				imageView.setFitHeight(150);
				imageView.setFitWidth(150);
				imageView.setTranslateX(20);
				homePage.getChildren().add(imageView);
		    	
				Label shoePrice = new Label("$"+price.get(3));
				homePage.getChildren().add(shoePrice);
				shoePrice.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));
				
				Label shoeColor = new Label("Color : "+color.get(3));
				homePage.getChildren().add(shoeColor);
				shoeColor.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));
				
				Label shoeSize = new Label("Size : "+size.get(3));
				homePage.getChildren().add(shoeSize);
				shoeSize.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));
				
				Label shoeRating = new Label("Rating : "+rating.get(3) + "/ 5.0");
				homePage.getChildren().add(shoeRating);
				shoeRating.setFont(Font.font("Comic Sans",FontWeight.BOLD,15));
				
				
				
				Button addToCart = new Button("ADD TO CART");
				addToCart.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						CSVUtilities.writeCSV(itemNames.get(3), 1, price.get(3),imageFiles.get(3));
						cartImageFiles.add(imageFiles.get(3));
					}
				});
				homePage.getChildren().add(addToCart); */
				
				homePage.setPadding(new Insets(0,0,-500,0)); // This is for the border problem
		  }
		});
		
		//SHOPPING CART AND CHECKOUT
		VBox cartPage = new VBox();
		Button shoppingCartButton = new Button("");
		FileInputStream  cartImage = new FileInputStream("cart.png") ; //
		Image imageCart = new Image(cartImage) ;//
		ImageView imageCartView = new ImageView(imageCart) ;//

		imageCartView.setFitHeight(35);//
		imageCartView.setFitWidth(35) ; //

		shoppingCartButton.setGraphic(imageCartView);//
		shoppingCartButton.setStyle("-fx-background-color: #ffffff; -fx-border-width: 5px; -fx-border-color: #cc0000");
		shoppingCartButton.setTranslateX(5);
		shoppingCartButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	homePage.getChildren().clear();
		    	Label shoppingCartLabel = new Label("Shopping Cart");
		    	shoppingCartLabel.setFont(Font.font("Comic Sans",FontWeight.BOLD,20));
		    	shoppingCartLabel.setTranslateX(147);
		    	homePage.getChildren().add(shoppingCartLabel);
		    	
		    	cartPage.getChildren().clear();
		    	cartPage.setStyle("-fx-border-color: #ff0000; -fx-border-width: 2px;");
		    	cartPage.setPrefHeight(1000);
		    	cartPage.setPrefWidth(200);
		    	homePage.getChildren().add(cartPage);
		    	
		    	setCartTitle(cartPage);  
		    	
			 
		    	Button checkoutButton = new Button("Checkout");
		    	checkoutButton.setStyle("-fx-background-color: #ffffff; -fx-border-width: 5px; -fx-border-color: #cc0000");
		    	
		    	//CLEAR BUTTON
		    	Button clearCartButton = new Button("Clear Cart");
		    	clearCartButton.setStyle("-fx-background-color: #ffffff; -fx-border-width: 5px; -fx-border-color: #cc0000");
		    	clearCartButton.setOnAction(new EventHandler<ActionEvent>() {
		    		public void handle(ActionEvent event)
		    		{
		    			//kart.clearCSV(cartImageFiles.size());
		    			File cart = new File("cart.csv");
		    			try {
							kart = new CSVUtilities(cart);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			kart.getCSVData().add("Name" + "," + "Quantity" + "," + "Price" + "," + "Image");
		    			try 
		    			{
		    				Files.write(Paths.get("cart.csv"), kart.getCSVData());
		    			} 
		    			catch (IOException e) {
		    				// TODO Auto-generated catch block
		    				e.printStackTrace();
		    			}
		    			StringBuilder sb = new StringBuilder();
		    			sb.append("Name,Quantity,Price,Image");
		    			PrintWriter cartPW = null;
		    			try {
							cartPW = new PrintWriter(cart);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			cartPW.write(sb.toString());
		    			cartPW.flush();
		    			cartPage.getChildren().clear();
		    			cartImageFiles.clear();
		    			cartPrices.clear();
		    			cartNames.clear();
		    			cartPages.clear();
		    			
		    			Text itemName = new Text("Item");
				    	itemName.setFont(Font.font("Comic Sans",FontPosture.ITALIC,14));
				    	itemName.setFill(Color.DARKSLATEGRAY);
				    	itemName.setTranslateX(20);
				    	itemName.setTranslateY(0);
				    	cartPage.getChildren().add(itemName);
				    	
				    	Text name = new Text("Name");
				    	name.setFont(Font.font("Comic Sans",FontPosture.ITALIC,14));
				    	name.setFill(Color.DARKSLATEGRAY);
				    	name.setTranslateX(175);
				    	name.setTranslateY(-20);
				    	cartPage.getChildren().add(name);
				    	
				    	Text price = new Text("Price");
				    	price.setFont(Font.font("Comic Sans",FontPosture.ITALIC,14));
				    	price.setFill(Color.DARKSLATEGRAY);
				    	price.setTranslateX(350);
				    	price.setTranslateY(-40);
				    	cartPage.getChildren().add(price);    
		    		}
		    	});
		    	homePage.getChildren().add(clearCartButton);
		    	
		    	//CART PAGE BUTTON HBOX
		    	HBox cartPageButtonHBox = setButtonsPageHBox(cartPage);
		    	homePage.getChildren().add(cartPageButtonHBox);
		    	
		    	//DISPLAYING FIRST PAGE
		    	if (cartImageFiles.size()>0)
		    	{
		    		for (int i = 0; i <cartImageFiles.size(); i++)
		    		{
		    			if (i<5)
		    			{
		    				Image image = new Image(cartImageFiles.get(i));
			    			ImageView imageView = new ImageView(image);
			    			imageView.setFitHeight(75);
			    			imageView.setFitWidth(100);
			    			imageView.setTranslateX(20);
			    			imageView.setTranslateY((i-2)*17);
			    			cartPage.getChildren().add(imageView);
			    			
			    			Label name = new Label(cartNames.get(i));
			    			name.setTranslateX(150);
			    			name.setTranslateY((i-5)*17);
			    			cartPage.getChildren().add(name);
			    			
			    			Label price = new Label("$"+cartPrices.get(i));
			    			price.setTranslateX(340);
			    			price.setTranslateY((i-6.25)*17);
			    			cartPage.getChildren().add(price);
		    			}
		    		}
		    	}
		    	else
		    	{
		    		Label cartMessage = new Label("No Items in Cart");
		    		homePage.getChildren().add(cartMessage);
		    	} 
		    	
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
										    	
									Text thanks = new Text("Thank you for shopping with" + "\nBig Baller Brand!" 
											    		+ "\nSTAY IN YO LANE!");
									thanks.setFont(Font.font("Comic Sans",FontPosture.ITALIC,24));
									thanks.setFill(Color.BLUEVIOLET);
									thanks.setTranslateX(25);
									thanks.setTranslateY(50);
									homePage.getChildren().add(thanks);
											    	
									FileInputStream input = null;
									try {
										input = new FileInputStream("lavar.gif");
									} 
									catch (FileNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									Image image = new Image(input);
									ImageView imageView = new ImageView(image);
									imageView.setFitHeight(400);
									imageView.setFitWidth(400);
									imageView.setTranslateX(18);
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
		hair.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		carsButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		musicButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		technology.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		shoes.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		TilePane tile = new TilePane(Orientation.HORIZONTAL);
		tile.setPadding(new Insets(20, 10, 20, 0));
		tile.setHgap(0.0);
		tile.setVgap(8.0);
		
		tile.getChildren().add(shoes);
		tile.getChildren().add(carsButton);
		tile.getChildren().add(musicButton);
		tile.getChildren().add(technology);
		tile.getChildren().add(hair);
		tile.getChildren().add(shoppingCartButton);
//		shoppingCartButton.setTranslateX(173);
		
	    VBox root = new VBox();
	   	//root.setPrefWidth(200);
		
		homePage.setStyle("-fx-border-color: #cc0000;-fx-border-width: 10px;");	//#ffedf3
		homePage.setPrefHeight(1000);
		homePage.setPrefWidth(200);
		
		FileInputStream input = new FileInputStream("bbb.jpg");
		Image image = new Image(input);
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(425);
		imageView.setFitWidth(425);
		imageView.setTranslateX(2);
		imageView.setTranslateY(20);
		homePage.getChildren().add(imageView);
		
		Text homeText = new Text("Big Baller Brand");
		homeText.setFont(Font.font("Comic Sans",FontWeight.BOLD,FontPosture.ITALIC,30));
		homeText.setFill(Color.BLUEVIOLET);
		homeText.setTranslateX(100);
		homeText.setTranslateY(50);
		homePage.getChildren().add(homeText);
		
	    root.getChildren().add(tile);
	    root.getChildren().add(homePage);
        Scene scene = new Scene(root, 450, 825);
        primaryStage.setTitle("Emazon");
	    primaryStage.setScene(scene);
	    primaryStage.show();
		
	}

	
	public static HBox setButtonsPageHBox(VBox cartPage)
	{
		cartPageButtonArrayList.clear();
		//CART PAGE BUTTON HBOX
    	HBox cartPageButtonHBox = new HBox();
    	
    	
    	//CREATING CART PAGES
    	int pageNumber = 1;
    	cartPages.clear();
    	int lengthCartImg = cartImageFiles.size();
    	for (int i = 0; i<lengthCartImg; i+=5)
    	{
    		ArrayList<String> page = new ArrayList<String>();
    		for (int x = i; x<i+5; x++)
    		{
    			if (x<lengthCartImg)
    			{
    				page.add(cartImageFiles.get(x));
    			}
    		}
    		cartPages.add(page);
    		
    		CartPageButton pageButtonCart = new CartPageButton(pageNumber);
    		Button pageButton = pageButtonCart.getButtonPage();
    		pageButton.setOnAction(new EventHandler<ActionEvent>() {
	    		public void handle(ActionEvent event)
	    		{	
	    			System.out.println("PageNumber="+pageButtonCart.getPageNum());
	    			cartPage.getChildren().clear();
	    			ArrayList<String> pageNow = cartPages.get(pageButtonCart.getPageNum()-1);
	    			setCartTitle(cartPage);
	    			for (int k = 0; k <pageNow.size(); k++)
	    			{
	    				Image image = new Image(cartImageFiles.get(k));
		    			ImageView imageView = new ImageView(image);
		    			imageView.setFitHeight(75);
		    			imageView.setFitWidth(100);
		    			imageView.setTranslateX(20);
		    			imageView.setTranslateY((k-2)*17);
		    			cartPage.getChildren().add(imageView);
		    			
		    			Label name = new Label(cartNames.get(k));
		    			name.setTranslateX(150);
		    			name.setTranslateY((k-5)*17);
		    			cartPage.getChildren().add(name);
		    			
		    			Label price = new Label("$"+cartPrices.get(k));
		    			price.setTranslateX(340);
		    			price.setTranslateY((k-6.25)*17);
		    			cartPage.getChildren().add(price);
	    			}
	    		}
	    	});
    		cartPageButtonArrayList.add(pageButton);
    		System.out.println(pageNumber);
    		pageNumber++;
    	}
    	
    	for (int i=0; i < cartPageButtonArrayList.size(); i++)
    	{
    		cartPageButtonHBox.getChildren().add(cartPageButtonArrayList.get(i));
    	}
    	
    	return cartPageButtonHBox;
	}
	
	public static void setCartTitle(VBox cartPage)
	{
		Text itemName = new Text("Item");
    	itemName.setFont(Font.font("Comic Sans",FontPosture.ITALIC,14));
    	itemName.setFill(Color.DARKSLATEGRAY);
    	itemName.setTranslateX(20);
    	itemName.setTranslateY(0);
    	cartPage.getChildren().add(itemName);
    	Text name = new Text("Name");
    	name.setFont(Font.font("Comic Sans",FontPosture.ITALIC,14));
    	name.setFill(Color.DARKSLATEGRAY);
    	name.setTranslateX(175);
    	name.setTranslateY(-20);
    	cartPage.getChildren().add(name);
    	Text price = new Text("Price");
    	price.setFont(Font.font("Comic Sans",FontPosture.ITALIC,14));
    	price.setFill(Color.DARKSLATEGRAY);
    	price.setTranslateX(350);
    	price.setTranslateY(-40);
    	cartPage.getChildren().add(price);
	}
	
	public static void settingItemTranslates(ImageView img, Label lb1, Label lb2, Label lb3, Label lb4, Label lb5, Label lb6, Button addToCart, Button play, int x, int y)
	{
		img.setTranslateX(x);
		img.setTranslateY(y);
		lb1.setTranslateX(x);
		lb1.setTranslateY(y);
		lb2.setTranslateX(x);
		lb2.setTranslateY(y);
		lb3.setTranslateX(x);
		lb3.setTranslateY(y);
		lb4.setTranslateX(x);
		lb4.setTranslateY(y);
		lb5.setTranslateX(x);
		lb5.setTranslateY(y);
		lb6.setTranslateX(x);
		lb6.setTranslateY(y);
		addToCart.setTranslateX(x);
		addToCart.setTranslateY(y);
		play.setTranslateX(x);
		play.setTranslateY(y);
	}
	
}
