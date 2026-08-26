package homework;
import java.util.Scanner;
public class monge3 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("원기둥의 밑면 반지름은? ");
        double radius = sc.nextDouble();
        
        System.out.print("원기둥의 높이는? ");
        double height = sc.nextDouble();
        
        double PI = 3.14;
        double volume = radius * radius * PI * height;
        
        System.out.println("원기둥의 부피는 " + volume);
        
        sc.close();
    }
}