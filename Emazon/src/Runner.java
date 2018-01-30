import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
public class Runner extends Application { 
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Runner runner = new Runner();
		
		primaryStage.setTitle("Emazon");
		
		Button shoppingCartButton = new Button("Cart");
		shoppingCartButton.setTranslateY(30);
		
		Button carsButton = new Button("Cars");
		carsButton.setTranslateX(-200);
		
		Button audioBookButton = new Button("Audio Books");
		audioBookButton.setTranslateX(-100);
		
		Button technology = new Button("Technology");
		
		Button clothing = new Button("Clothing");
		clothing.setTranslateX(100);
		
		Button shoes = new Button("Shoes");
		shoes.setTranslateX(200);
		
		shoppingCartButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	
		    }
		});
		
		
		StackPane stack = new StackPane();
		stack.getChildren().add(shoppingCartButton);
		stack.getChildren().add(carsButton);
		stack.getChildren().add(audioBookButton);
		stack.getChildren().add(technology);
		stack.getChildren().add(clothing);
		stack.getChildren().add(shoes);
		
	    VBox root = new VBox();
		root.setStyle("-fx-border-color: #0000cc; -fx-border-width: 5px;");
		
		VBox homePage = new VBox();
		homePage.setStyle("-fx-border-color: #00cc00; -fx-border-width: 5px;");
		homePage.setPrefHeight(300);
		homePage.setPrefWidth(200);
		
	    root.setSpacing(50);
	    root.getChildren().add(stack);
        Scene scene = new Scene(root, 450, 700);
        primaryStage.setTitle("Emazon");
	    primaryStage.setScene(scene);
	    primaryStage.show();
		
	}
	
	
}
