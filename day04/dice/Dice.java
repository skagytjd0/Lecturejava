package dice;

public class Dice {
    private int face;

    public Dice() {
        this.face = 6;
    }

    public int roll() {
        return (int) (Math.random() * face) + 1;
    }
}