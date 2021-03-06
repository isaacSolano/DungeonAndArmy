package DungeonAndArmy.Routes;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

import javafx.event.ActionEvent;
import java.io.IOException;

public class Router {
    public void navigateBoard(ActionEvent event) throws IOException {
        Parent board = FXMLLoader.load(getClass().getResource("/DungeonAndArmy/Board/Board.fxml"));
        Scene boradScene = new Scene(board, 900, 800);

        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Dungeon and Army");
        window.setScene(boradScene);
        window.show();
    }

    public void navigateEnd(ActionEvent event) throws IOException {
        Parent board = FXMLLoader.load(getClass().getResource("/DungeonAndArmy/Index/End.fxml"));
        Scene boradScene = new Scene(board, 900, 800);

        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Dungeon and Army");
        window.setScene(boradScene);
        window.show();
    }
}