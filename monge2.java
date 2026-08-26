package homework;

import java.util.Scanner;

public class monge2 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("정수를 입력하세요 : ");
        int num = sc.nextInt();
        
        int result = num * num;
        System.out.println(num + "의 제곱은 " + result);
        
        sc.close();
    }
}