package DungeonAndArmy.Routes;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

import javafx.event.ActionEvent;
import java.io.IOException;

public class Router {
    public void navigateBoard(ActionEvent event) throws IOException {
        Parent board = FXMLLoader.load(getClass().getResource("/DungeonAndArmy/Board/Board.fxml"));
        Scene boradEscena = new Scene(board, 800, 775);

        Stage ventana = (Stage)((Node) event.getSource()).getScene().getWindow();
        ventana.setTitle("Dungeon and Army");
        ventana.setScene(boradEscena);
        ventana.show();
    }
}