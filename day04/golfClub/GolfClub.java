package golfClub;

public class GolfClub {
    private int number;
    private String name;

    public GolfClub() {
        this.number = 7;
        this.name = null;
    }

    public GolfClub(int number) {
        this.number = number;
        this.name = null;
    }

    public GolfClub(String name) {
        this.number = 0;
        this.name = name;
    }

    public void print() {
        if (name == null) {
            System.out.println(name + "입니다.");
        } else {
            System.out.println(number + "번 아이언입니다.");
        }
    }
}