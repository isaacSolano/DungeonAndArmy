package DungeonAndArmy.Helper;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class FileManager {
    private ArrayList<ImageView> arrImages = new ArrayList<>();

    public FileManager(){
        arrImages.add( resizeImage("Media/L.png") );
        arrImages.add( resizeImage("Media/Cruz.png") );
        arrImages.add( resizeImage("Media/Z.png") );
        arrImages.add( resizeImage("Media/P.png") );
        arrImages.add( resizeImage("Media/U.png") );
        arrImages.add( resizeImage("Media/T.png") );
    }

    public ImageView resizeImage(String url){
        ImageView image = new ImageView(url);

        image.setFitHeight(50);
        image.setFitWidth(50);

        return image;
    }

    public ArrayList<ImageView> getImages(){
        return this.arrImages;
    }
}
