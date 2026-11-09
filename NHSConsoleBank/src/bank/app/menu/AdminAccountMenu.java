package bank.app.menu;

import bank.account.AccountService;
import bank.app.console.ConsoleMenu;
import bank.member.MemberService;

public class AdminAccountMenu extends ConsoleMenu {

    protected AdminAccountMenu(AccountService as, MemberService ms) {
        super(as, ms);
        menuList = new String[]{"돌아가기", "전체 계좌 목록", "회원별 계좌 목록"};
    }

    @Override
    public void run() {
        System.out.println("계좌 관리 메뉴");
        while (true) {
            int menu = selectMenu();
            switch (menu) {
                case 1 ->
                    accountList();
                case 2 ->
                    memberAccountList();
                case 0 -> {
                    out();
                    return;
                }
                default ->
                    System.out.println("잘못된 입력입니다");
            }
        }
    }

    private void accountList() {
        System.out.println("전체 계좌 목록");
    }

    private void memberAccountList() {
        System.out.println("회원별 계좌 목록");
    }

    private void out() {
        System.out.println("돌아가기");
    }
}


