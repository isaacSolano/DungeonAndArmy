package DungeonAndArmy.AbstractFactoryPattern.AbstractProduct;

/**
 * The "army" interface contains the methods that specific products must implement.
 */

public interface Soldier {
    public void move();
    public void attack();
    public void launchSpecialAttack();
}
