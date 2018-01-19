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
	    gridPane.setAlignment(Pos.TOP_CENTER);
	    gridPane.setHgap(10);
	    gridPane.setVgap(10);
	    gridPane.setPadding(new Insets(10));
	    gridPane.setGridLinesVisible(true);
	    
	    
	    gridPane.add(shoppingCartButton, 3, 2);
	    gridPane.add(carsButton, 3, 0);
	    gridPane.add(audioBookButton, 1, 0);
	    gridPane.add(technology, 2, 0);
	    gridPane.add(shoes, 4, 0);
	    gridPane.add(clothing, 5, 0);
	    
	    VBox root = new VBox();
		
	   
	    root.setSpacing(50);
	    root.getChildren().add(gridPane);
	    GridPane.setHalignment(shoppingCartButton, HPos.CENTER);
	    GridPane.setValignment(shoppingCartButton, VPos.BASELINE);
        Scene scene = new Scene(root, 450, 700);
        primaryStage.setTitle("Emazon");
	    primaryStage.setScene(scene);
	    primaryStage.show();
		
	}
	
	
}
