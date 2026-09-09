package cat;

public class Testcat {
	public static void main(String[] args) {
		
		Cat myCat = new Cat("코숏","brown");
		System.out.println("나의 고양이는 " + myCat.color +" "+ myCat.breed + "입니다.");
		myCat.eat("아침");
		myCat.scratch();
		myCat.meow();
		//myCat.setColor("brown");
		System.out.println();
		myCat.meow();
		System.out.println();
		myCat.eat("점심");
		myCat.scratch();
		myCat.meow();
	}
}
