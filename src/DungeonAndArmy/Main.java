package DungeonAndArmy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryWindow) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Index/Index.fxml"));
        primaryWindow.setTitle("Dungeon and Army");
        primaryWindow.setScene(new Scene(root, 900, 800));
        primaryWindow.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
