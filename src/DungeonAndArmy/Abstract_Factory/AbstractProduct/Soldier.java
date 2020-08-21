package DungeonAndArmy.Abstract_Factory.AbstractProduct;

import javafx.scene.image.ImageView;

/**
 * The "army" interface contains the methods that specific products must implement.
 */

public interface Soldier {
    int getAttack();
    int getDefense();
    int getLife();

    void setDefense(int defense);
    void setLife(int life);
    void launchSpecialAttack();
    void setCoords(String coords);
    ImageView getImage();
    String getCoords();
    int getMove();
}
