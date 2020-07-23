package DungeonAndArmy.Helper;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class FileManager {
    private ArrayList<ImageView> arrImagesPaths = new ArrayList<>();
    private ArrayList<ImageView> arrImagesMonsters = new ArrayList<>();

    public FileManager(){
        arrImagesPaths.add( resizeImage("Media/L.png") );
        arrImagesPaths.add( resizeImage("Media/Cruz.png") );
        arrImagesPaths.add( resizeImage("Media/Z.png") );
        arrImagesPaths.add( resizeImage("Media/P.png") );
        arrImagesPaths.add( resizeImage("Media/U.png") );
        arrImagesPaths.add( resizeImage("Media/T.png") );

        arrImagesMonsters.add( resizeImage("Media/Army/Aerys.png") );
        arrImagesMonsters.add( resizeImage("Media/Army/Arryn.png") );
        arrImagesMonsters.add( resizeImage("Media/Army/Arthur.png") );
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
}
