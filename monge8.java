package homework;
import java.util.Scanner;
public class monge8 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("0~999 사이의 숫자를 입력하세요 : ");
        int number = sc.nextInt();
        
        int hundred = number / 100;
        int ten = (number % 100) / 10;
        int one = number % 10;
        
        int sum = hundred + ten + one;
        
        System.out.println("각 자릿수의 합 = " + sum);
        
        sc.close();
    }
}