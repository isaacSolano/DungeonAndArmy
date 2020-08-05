package DungeonAndArmy.Helper;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class FileManager {
    private ArrayList<ImageView> arrImagesPaths = new ArrayList<>();
    private ArrayList<ImageView> arrImagesMonsters = new ArrayList<>();
    private ArrayList<ImageView> arrImagesMovementDice = new ArrayList<>();
    private final ImageView movement = resizeImage("Media/Dice/Options/movement.png");
    private final ImageView attack = resizeImage("Media/Dice/Options/attack.png");
    private final ImageView special = resizeImage("Media/Dice/Options/special.png");
    private final ImageView summoning = resizeImage("Media/Dice/Options/summoning.png");

    public ImageView getMovement() {
        return movement;
    }

    public ImageView getAttack() {
        return attack;
    }

    public ImageView getSpecial() {
        return special;
    }

    public ImageView getSummoning() {
        return summoning;
    }

    public FileManager(){
        arrImagesPaths.add( resizeImage("Media/Path/L.png") );
        arrImagesPaths.add( resizeImage("Media/Path/Cruz.png") );
        arrImagesPaths.add( resizeImage("Media/Path/Z.png") );
        arrImagesPaths.add( resizeImage("Media/Path/P.png") );
        arrImagesPaths.add( resizeImage("Media/Path/U.png") );
        arrImagesPaths.add( resizeImage("Media/Path/T.png") );

        arrImagesMonsters.add( resizeImage("Media/Army/Aerys.png") );
        arrImagesMonsters.add( resizeImage("Media/Army/Arryn.png") );
        arrImagesMonsters.add( resizeImage("Media/Army/Arthur.jpg") );
        arrImagesMonsters.add( resizeImage("Media/Army/Boko.png") );
        arrImagesMonsters.add( resizeImage("Media/Army/Bora.png") );
        arrImagesMonsters.add( resizeImage("Media/Army/Brienne.png") );
        arrImagesMonsters.add( resizeImage("Media/Army/Bronn.png") );
        arrImagesMonsters.add( resizeImage("Media/Army/Castlely.png") );
        arrImagesMonsters.add( resizeImage("Media/Army/Forerunner.png") );
        arrImagesMonsters.add( resizeImage("Media/Army/Glognar.png") );
        arrImagesMonsters.add( resizeImage("Media/Army/Helms.png") );
        arrImagesMonsters.add( resizeImage("Media/Army/Obara.png") );
        arrImagesMonsters.add( resizeImage("Media/Army/Rhaegon.png") );
        arrImagesMonsters.add( resizeImage("Media/Army/Siddon.png") );
        arrImagesMonsters.add( resizeImage("Media/Army/Varys.png") );

        arrImagesMonsters.add( resizeImage("Media/Army/Artillery.jpeg") );
        arrImagesMonsters.add( resizeImage("Media/Army/Infantry.jpeg") );
        arrImagesMonsters.add( resizeImage("Media/Army/Tanks.jpeg") );

        arrImagesMovementDice.add( resizeImage("Media/Dice/Movement/dice1.png"));
        arrImagesMovementDice.add( resizeImage("Media/Dice/Movement/dice2.png"));
        arrImagesMovementDice.add( resizeImage("Media/Dice/Movement/dice3.png"));
        arrImagesMovementDice.add( resizeImage("Media/Dice/Movement/dice4.png"));
        arrImagesMovementDice.add( resizeImage("Media/Dice/Movement/dice5.png"));
        arrImagesMovementDice.add( resizeImage("Media/Dice/Movement/dice6.png"));

    }

    public ImageView resizeImage(String url){
        ImageView image = new ImageView(url);

        image.setFitHeight(50);
        image.setFitWidth(50);

        return image;
    }

    public ArrayList<ImageView> getPathImages(){
        return this.arrImagesPaths;
    }

    public ArrayList<ImageView> getArrImagesMonsters(){
        return this.arrImagesMonsters;
    }

    public ArrayList<ImageView> getArrImagesMovementDice() {
        return this.arrImagesMovementDice;
    }
}
