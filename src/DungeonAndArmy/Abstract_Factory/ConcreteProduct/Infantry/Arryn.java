package DungeonAndArmy.Abstract_Factory.ConcreteProduct.Infantry;

import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import javafx.scene.image.ImageView;

public class Arryn implements Soldier {
    private static final String category = "Infantería";
    private final String name = "Arryn";
    private ImageView image = new ImageView("Media/Army/Arryn.png");

    private String coords;
    private int move;
    private int life;
    private int attack;
    private int defense;
    private int specialAttack;

    /**
     * builders section
     */
    public Arryn() {
    }

    public Arryn(String coords, int move, int life, int attack, int defense, int specialAttack) {
        this.coords = coords;
        this.move = move;
        this.life = life;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
    }

    /**
     *get section
     */
    public static String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getCoords() {
        return coords;
    }

    public int getMove() {
        return move;
    }

    public int getLife() {
        return life;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    /**
     * set section
     */
    public void setMove(int move) {
        this.move = move;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }


    /**
     * Section to implement interface functions
     */
    @Override
    public void move() {

    }

    @Override
    public void attack() {

    }

    @Override
    public void launchSpecialAttack() {
        this.coords = coords;
    }

    @Override
    public void setCoords(String coords) {
        this.coords = coords;
    }

    @Override
    public ImageView getImage() {
        return image;
    }
}
