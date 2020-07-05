package DungeonAndArmy.Helper;

import javafx.scene.control.Alert;

public class AlertHelper {
    public AlertHelper(){

    }

    public Alert createErr(String header, String body){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(body);

        return alert;
    }
}
