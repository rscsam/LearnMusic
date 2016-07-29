package control;

/**
 * Created by Sam Costley on 3/19/2016.
 */
public class PracticeSettings {
    private boolean treble, bass, alto;
    private int speed;

    public PracticeSettings(boolean treble, boolean bass, boolean alto, int speed) {
        this.treble = treble;
        this.bass = bass;
        this.alto = alto;
        this.speed = speed;
    }

    public static PracticeSettings formFromInts(int[] nums) {
        boolean treble = nums[0] == 0;
        boolean bass = nums[1] == 0;
        boolean alto = nums[2] == 0;
        int speed = nums[3];
        return new PracticeSettings(treble, bass, alto, speed);
    }

    public int[] toInts() {
        int[] ints = new int[4];
        if (treble) {
            ints[0] = 0;
        } else {
            ints[0] = 1;
        }
        if (bass) {
            ints[1] = 0;
        } else {
            ints[1] = 1;
        }
        if (alto) {
            ints[2] = 0;
        } else {
            ints[2] = 1;
        }
        ints[3] = speed;
        return ints;
    }

    public boolean treble() { return treble; }
    public boolean bass() { return bass; }
    public boolean alto() { return alto; }
    public int speed() { return speed; }
}
