package cat;

public class Cat {

	// 필드 == 멤버변수 == 인스턴스 변수
	String breed;
	String color;
	int age;
	
	public Cat(String breed, String color, int age) {
		this. breed = breed;
		this. color = color;
		this. age = age ;
	}
	public Cat(String breed, String color) {
//		this. breed = breed;
//		this. color = color;
		this(breed, color,0);
	}	
	public Cat(String breed) {
//		this. breed = breed;
		this(breed, null,0);
	}
	
	void eat(String time) {
		System.out.println(time + "에 사료를 먹습니다.");
	}

	void scratch() {
		System.out.println("스크레치을 긁습니다");
	}

	void meow() {
		System.out.println("야옹---.");
	}
	void setColor(String color) {
		this. color = color;
	}
}

