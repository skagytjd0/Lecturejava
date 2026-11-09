package bank.app.menu;

import bank.account.AccountService;
import bank.app.console.ConsoleMenu;
import bank.member.MemberService;

public class AdminMenu extends ConsoleMenu {

	public AdminMenu(AccountService as, MemberService ms) {
		super(as, ms);
		menuList = new String[] {"로그아웃", "회원관리", "계좌관리"};
	}

	@Override
	public void run() {
		System.out.println("관리자 메뉴");
		while (true) {
			int menu = selectMenu();
			switch (menu) {
			case 1 -> manageMembers();
			case 2 -> manageAccounts();
			case 0 -> {return;}
			default -> System.out.println("잘못된 입력입니다");
			}
		}
	}

	private void manageMembers() {
		System.out.println("회원관리");
		new AdminMemberMenu(as, ms).run();
	}

	private void manageAccounts() {
		System.out.println("계좌관리");
		new AdminAccountMenu(as, ms).run();
	}

}
