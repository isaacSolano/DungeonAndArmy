package DungeonAndArmy.Abstract_Factory.AbstractProduct;

import javafx.scene.image.ImageView;

/**
 * The "army" interface contains the methods that specific products must implement.
 */

public interface Soldier {
    void move();
    void attack();
    void launchSpecialAttack();
    void setCoords(String coords);
    ImageView getImage();
    String getCoords();
    int getMove();
}
