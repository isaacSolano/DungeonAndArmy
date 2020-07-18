package DungeonAndArmy.AbstractFactoryPattern.ConcreteProduct.Tank;

import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;

public class Rhaegon implements Soldier {
    private static final String category = "Tanque";
    private static final String imgUrl = "Media/Army/Rhaegon";

    private int id;
    private int move;
    private int life;
    private int attack;
    private int defense;
    private int specialAttack;

    /**
     * builders section
     */
    public Rhaegon() {
    }

    public Rhaegon(int id, int move, int life, int attack, int defense, int specialAttack) {
        this.id = id;
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

    public static String getImgUrl() {
        return imgUrl;
    }

    public int getId() {
        return id;
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

    }
}
