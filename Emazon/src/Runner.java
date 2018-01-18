import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Runner extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Runner runner = new Runner();
		
		primaryStage.setTitle("Emazon");
		
		Button shoppingCartButton = new Button("Cart");
		Button carsButton = new Button("Cars");
		Button audioBookButton = new Button("Audio Books");
		Button technology = new Button("Technology");
		Button clothing = new Button("Clothing");
		Button shoes = new Button("Shoes");
		
		shoppingCartButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	
		    }
		});
		
		GridPane gridPane = new GridPane();
	    gridPane.setAlignment(Pos.CENTER);
	    gridPane.setHgap(20);
	    gridPane.setVgap(20);
	    
	    gridPane.add(shoppingCartButton, 0, 0);
	    
	    VBox root = new VBox();
		
	    root.setAlignment(Pos.CENTER);
	    root.setSpacing(50);
	    root.getChildren().add(gridPane);
	    
        Scene scene = new Scene(root, 550, 400);
        primaryStage.setTitle("Emazon");
	    primaryStage.setScene(scene);
	    primaryStage.show();
		
	}
	
	
}
