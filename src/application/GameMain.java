package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameMain extends Application {
	private int score = 0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// The window is a borderpane
			BorderPane mainPane = new BorderPane();
			Group root = new Group();
			Scene scene = new Scene(root,600,400);
			
			// Set background colour
			mainPane.setStyle("-fx-background-color: yellow;");
			
			TabPane tp = new TabPane();
			
			//The this here is passing the object main into all of them so they can use the score getter and setter
			tp.getTabs().add(new IntroPanel());
			tp.getTabs().add(new GuessGameView(this));
			tp.getTabs().add(new LotteryGameView(this));
			tp.getTabs().add(new PrizeSelectionView(this));
			              			
			mainPane.setCenter(tp);	  
			mainPane.prefHeightProperty().bind(scene.heightProperty());
			mainPane.prefWidthProperty().bind(scene.widthProperty());
		     
		    root.getChildren().add(mainPane);
			
		    primaryStage.setScene(scene);
			primaryStage.show();
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Editing the score methods
	public int get_score() {
		return score;
	}
	
	public void set_score(int n) {
		score += n;
	}
	
	public void reduce_score(int x) {
		score = score - x;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
