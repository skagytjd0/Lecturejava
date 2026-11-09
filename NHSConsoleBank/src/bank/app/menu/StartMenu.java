package bank.app.menu;

import bank.account.AccountService;
import bank.app.console.ConsoleMenu;
import bank.member.Member;
import bank.member.MemberService;

public class StartMenu extends ConsoleMenu {

    public StartMenu(AccountService as, MemberService ms) {
        super(as, ms);
        this.menuList = new String[]{"종료", "로그인", "회원가입"};
    }

    @Override
    public void run() {
        showWelcome();
        while (true) {
            int menu = selectMenu();
            switch (menu) {
                case 1 ->
                    login();
                case 2 ->
                    join();
                case 0 -> {
                    sayGoodbye();
                    return;
                }
                default ->
                    System.out.println("입력이 잘못됨");
            }
        }

    }

    private void showWelcome() {
        System.out.println("시작 메뉴");
    }

    private void sayGoodbye() {
        System.out.println("이용해 주셔서 감사합니다.");

    }

    private void login() {
        System.out.println("::: 로그인 :::");
        String id = input.readString(">> 아이디 : ");
        String password = input.readString(">> 비밀번호 : ");

        boolean isOk = ms.login(id, password);
        if (isOk) {
            switch (ms.getLoggedMember().getType()) {
                case Member.ADMIN ->
                    new AdminMenu(as, ms).run();
                case Member.USER ->
                    new BankingMenu(as, ms).run();
            }
        } else {
            System.out.println("로그인 할 수 없습니다.");
        }
    }

    private void join() {
        System.out.println("회원가입");
        String id = input.readString("아이디");
        String password = input.readString("비밀번호");
        String name = input.readString("이름");
        if (ms.join(id, password, name)) {
            System.out.println("회원가입완료");
        } else {
            System.out.println("회원가입실패");
        }
    }
}
