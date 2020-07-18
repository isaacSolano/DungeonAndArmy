package DungeonAndArmy.Helper;

import java.util.ArrayList;
import java.util.Arrays;

public class Helper {
    public Helper(){ }

    public int getRandom(int max){
        return (int) Math.floor(Math.random() * max+1);
    }

    public ArrayList<Integer> generateArrX(String type) {
        ArrayList<Integer> arrX;

        switch(type){
            case "L": case "U":
                arrX = new ArrayList<>(Arrays.asList(0, 1, 2));
                break;

            case "Cruz": case "T":
                arrX = new ArrayList<>(Arrays.asList(-1, 0, 1));
                break;

            case "Z":
                arrX = new ArrayList<>(Arrays.asList(0, 1, 0, 1));
                break;

            case "P":
                arrX = new ArrayList<>(Arrays.asList(0, 1));
                break;

            default:
                arrX = null;
                break;
        }

        return arrX;
    }
}
