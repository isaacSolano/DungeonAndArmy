package DungeonAndArmy.Singleton.Round;

import DungeonAndArmy.Dice.iPrototype.Die;

import java.util.ArrayList;

public class Player {

    private String id;
    private int basePosition;
    private ArrayList<String> cofre = new ArrayList<>();

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

    public String agregarDado(Die pDie){
        int cantI = 0, cantM=0, cantA =0,cantE =0;

        for (String dado:cofre) {

            switch (dado){

                case "Artillero": case "Tanque": case "Infanteria":
                    cantI++;
                    break;
                case "1": case "2": case "3":case "4":case "5":case "6":
                    cantM++;
                    break;
                case "Atk":
                    cantA++;
                    break;
                case "SP":
                    cantE++;
                    break;
            }

        }
        switch (pDie.getType()){

            case "Invocacion":
                if(cantI <= 6){
                    cofre.add(pDie.getFace());
                }
                break;
            case "Accion":

                switch (pDie.getFace()){

                    case "Movimiento":
                        if (cantM <= 3){

                        }
                        break;
                    case "Atk":
                        if (cantA <= 3){
                            cofre.add("Atk");
                        }
                        break;
                    case "SP":
                        if (cantA <= 2){
                            cofre.add("SP");
                        }
                        break;
                }




        }

        return "Dado agregado";
    }

    //Usar lo que hay adentro del cofre
    public String usarCofre(String pDado){

        for (String dado:cofre) {
            if(dado.equals(pDado)){
                cofre.remove(dado);
                return dado;
            }
        }

        return null;
    }

    public String[] listarDados(){
        String info[] = new String[cofre.size()];
        int cont = 0;
        for (String dados:cofre) {
            info[cont] = dados;
            cont++;
        }
        return info;

    }

    @Override
    public String toString() {
        return "El jugador: " + id + " inicia en la posicion " + basePosition;
    }
}
