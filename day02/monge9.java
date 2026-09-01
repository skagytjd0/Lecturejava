package homework;
import java.util.Scanner;
public class monge9 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("전공 이수 학점 : ");
        int major = sc.nextInt();
        
        System.out.print("교양 이수 학점 : ");
        int liberal = sc.nextInt();
        
        System.out.print("일반 이수 학점 : ");
        int general = sc.nextInt();
        
        String result = ((major + liberal + general >= 140) && 
                         (major >= 70) && 
                         ((liberal >= 30 && general >= 30) || (liberal + general >= 80))) 
                         ? "졸업 가능" : "졸업 불가능";
                         
        System.out.println("\n" + result);
        
        sc.close();
    }
}
