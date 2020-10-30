package ro.jademy.javafx.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
    //    Parent root = FXMLLoader.load(getClass().getResource("/fxml/tableViewDB.fxml"));
        primaryStage.setTitle("JavaFX Demo Application");
        primaryStage.setScene(new Scene(root, 1024, 640));
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
