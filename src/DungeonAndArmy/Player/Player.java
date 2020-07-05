package DungeonAndArmy.Player;

public class Player {

    private String id;
    private int basePosition;

    //CONSTRUCTOR
    public Player(String id, int basePosition) {
        this.id = id;
        this.basePosition = basePosition;
    }

    //GETS Y SETS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBasePosition() {
        return basePosition;
    }

    public void setBasePosition(int basePosition) {
        this.basePosition = basePosition;
    }

    @Override
    public String toString() {
        return "El jugador: " + id + " inicia en la posicion " + basePosition;
    }
}
