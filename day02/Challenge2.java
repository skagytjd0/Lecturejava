package homework;

import java.util.Scanner;

public class Challenge2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("정수를 입력하세요 : ");
        int num = in.nextInt();
        
        String result = (num % 2 == 0) ? "짝수" : "홀수";
        
        System.out.println(result);
        
        in.close();
    }
}
