package workoutApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("Workout plan");
        primaryStage.setScene(new Scene(root, 800, 650));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
