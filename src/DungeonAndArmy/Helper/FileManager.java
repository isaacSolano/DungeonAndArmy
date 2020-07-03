package DungeonAndArmy.Helper;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class FileManager {
    private ArrayList<ImageView> arrImages = new ArrayList<>();

    public FileManager(){
        arrImages.add( new ImageView("Media/L.png") );
        arrImages.add( new ImageView("Media/Cruz.png") );
        arrImages.add( new ImageView("Media/Z.png") );
        arrImages.add( new ImageView("Media/P.png") );
        arrImages.add( new ImageView("Media/U.png") );
        arrImages.add( new ImageView("Media/T.png") );
    }

    public ArrayList<ImageView> getImages(){
        return this.arrImages;
    }
}
