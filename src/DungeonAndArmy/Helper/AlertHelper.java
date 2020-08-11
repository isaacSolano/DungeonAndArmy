package DungeonAndArmy.Helper;

import javafx.scene.control.Alert;

public class AlertHelper {
    public AlertHelper(){

    }


    /**
     * @param body Body content.
     * @return Alert that will pop up on the screen.
     */
    public Alert createErr(String body){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("No se puede completar la accion");
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
