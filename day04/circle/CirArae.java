package circle;

import java.util.Scanner;

public class CirArae {
	public static void main(String[] args) {
		// 원의 반지름 입력받아서
		Scanner sc = new Scanner(System.in);
		System.out.print("원의 반지름 : ");
		double radius = sc.nextDouble();
		// Circle 객체 생성
		Circle c = new Circle(radius);
		// Circle 객체에게 면적 계산 요청
		double area = c.getArea();
		//면적 출력
		System.out.printf("반지름이 %f인 원의 넓이는 %2f입니다", c.getRadius(), area);
		

	}
}
