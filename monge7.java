package homework;
import java.util.Scanner;
public class monge7 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("정수를 입력하세요 : ");
        int x = sc.nextInt();
        
        System.out.println("①4와 5로 모두 나누어짐 : " + ((x % 4 == 0) && (x % 5 == 0)));
        
        System.out.println("②4 또는 5로 나누어짐 : " + ((x % 4 == 0) || (x % 5 == 0)));
        
        System.out.println("③4나 5 중 하나로만 나누어짐 : " + ((x % 4 == 0) ^ (x % 5 == 0)));
        
        sc.close();
    }
}