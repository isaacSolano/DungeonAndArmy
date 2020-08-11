package DungeonAndArmy.Helper;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class FileManager {
    private ArrayList<ImageView> arrImagesPaths = new ArrayList<>();
    private ArrayList<ImageView> arrImagesMonsters = new ArrayList<>();
    private ArrayList<ImageView> arrImagesActions = new ArrayList<>();
    private ArrayList<String> arrUrlImagesMovementDices = new ArrayList<>();

    public FileManager(){
        arrImagesPaths.add( resizeImage("Media/Path/L.png") );
        arrImagesPaths.add( resizeImage("Media/Path/Cross.png") );
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

        arrImagesMonsters.add( resizeImage("Media/Army/Artillery.png") );
        arrImagesMonsters.add( resizeImage("Media/Army/Infantry.png") );
        arrImagesMonsters.add( resizeImage("Media/Army/Tanks.png") );

        arrUrlImagesMovementDices.add( "Media/Dice/Movement/Dice1.png" );
        arrUrlImagesMovementDices.add( "Media/Dice/Movement/Dice2.png" );
        arrUrlImagesMovementDices.add( "Media/Dice/Movement/Dice3.png" );
        arrUrlImagesMovementDices.add( "Media/Dice/Movement/Dice4.png" );
        arrUrlImagesMovementDices.add( "Media/Dice/Movement/Dice5.png" );
        arrUrlImagesMovementDices.add( "Media/Dice/Movement/Dice6.png");

        arrImagesActions.add( resizeImage("Media/Dice/Options/Movement.png") );
        arrImagesActions.add( resizeImage("Media/Dice/Options/Attack.png") );
        arrImagesActions.add( resizeImage("Media/Dice/Options/Summoning.png") );
        arrImagesActions.add( resizeImage("Media/Dice/Options/Special.png") );
    }

    public ImageView resizeImage(String url){
        ImageView image = new ImageView(url);

        image.setFitHeight(50);
        image.setFitWidth(50);

        return image;
    }

    public ArrayList<ImageView> getArrImagesPath(){
        return this.arrImagesPaths;
    }

    public ArrayList<ImageView> getArrImagesMonsters(){
        return this.arrImagesMonsters;
    }

    public ImageView getArrImagesMovementDice(int pos) {
        return resizeImage( arrUrlImagesMovementDices.get(pos) );
    }

    public ArrayList<ImageView> getArrImagesActions(){
        return this.arrImagesActions;
    }
}
