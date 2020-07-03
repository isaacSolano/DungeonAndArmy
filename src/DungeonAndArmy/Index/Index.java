package DungeonAndArmy.Index;

import DungeonAndArmy.Routes.Router;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class Index {
    private Router router = new Router();

    public Button StartBtn;

    public void navigateBoard(ActionEvent event) throws IOException {
        router.navigateBoard(event);
    }
}
