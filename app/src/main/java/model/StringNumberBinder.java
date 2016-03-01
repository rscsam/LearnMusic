package model;

/**
 * Created by Sam Costley on 2/9/2016.
 */
public class StringNumberBinder {
    private String string;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private int number;

    public StringNumberBinder(String string, int number) {
        this.string = string;
        this.number = number;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string + ": " + number;
    }
}
