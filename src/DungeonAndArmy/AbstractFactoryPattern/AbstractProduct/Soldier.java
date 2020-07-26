package DungeonAndArmy.AbstractFactoryPattern.AbstractProduct;

import javafx.scene.image.ImageView;

/**
 * The "army" interface contains the methods that specific products must implement.
 */

public interface Soldier {
    public void move();
    public void attack();
    public void launchSpecialAttack();
    void setCoords(String coords);
    ImageView getImage();
    String getCoords();
}
