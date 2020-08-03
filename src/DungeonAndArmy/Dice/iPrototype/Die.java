package DungeonAndArmy.Dice.iPrototype;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Die {
    protected String type, color;
    protected String[] faces;

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    /**
     * Descripcion: Permite que se clonen nuevas instancias a partir de esta clase.
     *
     * @return Nueva instancia con modificaciones basadas en el tipo de clase deseada.
     */
    public abstract Die clone();

    /**
     * @return valor al azar de una de las caras del dado
     */
    public String getFace() {
        return faces[ThreadLocalRandom.current().nextInt(0,6)];
    }

    /**
     * @return String de datos con todas las caras del Dado.
     */
    public String getAllFaces() {
        String faceData = "Caras del Dado:\n";
        for (int i = 0; i < this.faces.length; i++) {
            faceData += "Cara #" + i + ": " + faces[i] + "\n";
        }
        return faceData;
    }

    /**
     * Descripcion: Convierte toda la informacion del Dado a String y lo retorna.
     *
     * @return Informacion de los datos contenidos por el dado.
     */
    public String getData() {
        String mData = "#### Informacion del Dado ####\n";
        mData += "Tipo de Dado: " + this.getType() + "\n";
        mData += "Color: " + this.getColor() + "\n";
        mData += this.getAllFaces();
        return mData;
    }
}
