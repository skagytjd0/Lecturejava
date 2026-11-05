package bank.app.menu;

import bank.account.AccountService;
import bank.app.console.ConsoleMenu;
import bank.member.MemberService;

public class MyInfoMenu extends ConsoleMenu{

	protected MyInfoMenu(AccountService as, MemberService ms) {
		super(as, ms);
		menuList = new String[] {"돌아가기", "비밀번호 수정", "회원탈퇴"};
	}

	@Override
	public void run() {
		System.out.println("::: 내 정보 메뉴 :::");
		while(true) {
			int menu = selectMenu();
			switch(menu) {
			case 1 -> changePassword();
			case 2 -> deleteMember();
			case 0 -> {out(); return;}
			default -> System.out.println("!! 메뉴에 있는 번호 선택 !!");
			}
		}
	}

	private void deleteMember() {
		System.out.println("회원탈퇴");
	}

	private void changePassword() {
		System.out.println("비밀번호 변경");
	}
	private void out() {
		System.out.println("돌아가기");
	}
}
