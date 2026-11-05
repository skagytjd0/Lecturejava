package bank.app.menu;

import bank.account.AccountService;
import bank.app.console.ConsoleMenu;
import bank.member.MemberService;

public class AdminAccountMenu extends ConsoleMenu{

	protected AdminAccountMenu(AccountService as, MemberService ms) {
		super(as, ms);
		menuList = new String[] {"돌아가기", "전체 계좌 목록", "회원별 계좌 목록"};
	}

	@Override
	public void run() {
		System.out.println("::: 계좌 관리 메뉴 :::");
		while(true) {
			int menu = selectMenu();
			switch(menu) {
			case 1 -> allAccounts();
			case 2 -> memberAccounts();
			case 0 -> {logout(); return;}
			default -> System.out.println("!! 메뉴에 있는 번호 선택 !!");
			}
		}
	}

	private void allAccounts() {
		System.out.println("전체 계좌 목록");
	}

	private void memberAccounts() {
		System.out.println("회원별 계좌 목록");
	}
	private void logout() {
		System.out.println("돌아가기");
		
	}
}


