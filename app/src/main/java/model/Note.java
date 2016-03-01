package model;

/**
 * Links together a note value and an image
 * Created by Sam Costley on 2/9/2016.
 */
public class Note {
    private String value;
    private int image; //reference

    public Note(String value, int image) {
        this.value = value;
        this.image = image;
    }

    public String getValue() {
        return value;
    }

    public int getImage() {
        return image;
    }
}
