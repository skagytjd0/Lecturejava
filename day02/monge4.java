package homework;
import java.util.Scanner;
public class monge4 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("초 단위 정수를 입력하세요 : ");
        int totalSeconds = sc.nextInt();
        
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        
        System.out.println(hours + "시간 " + minutes + "분 " + seconds + "초");
        
        sc.close();
    }
}
