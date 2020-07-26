package DungeonAndArmy.Helper;

import javafx.scene.control.Alert;

public class AlertHelper {
    public AlertHelper(){

    }


    /**
     * @param header Header content.
     * @param body Body content.
     * @return Alert that will pop up on the screen.
     */
    public Alert createErr(String header, String body){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(body);

        return alert;
    }

    public Alert createInfo(String header, String body){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(header);
        alert.setContentText(body);

        return alert;
    }
}
