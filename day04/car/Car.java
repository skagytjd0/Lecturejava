package car;

public class Car {
    private String color;
    private static int numOfCar = 0;
    private static int numOfRedCar = 0;

    public Car(String color) {
        this.color = color;
        numOfCar++;

        if ((color.equals("red") || color.equals("RED"))) {
            numOfRedCar++;
        }
    }
    public static int getNumOfCar() {
        return numOfCar;
    }

    public static int getNumOfRedCar() {
        return numOfRedCar;
    }
}