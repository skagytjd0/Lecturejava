package bank.app;

import bank.account.AccountListDao;
import bank.account.AccountService;
import bank.account.NHSAccountService;
import bank.app.menu.StartMenu;
import bank.member.MemberOracleDao;
import bank.member.MemberService;
import bank.member.NHSMemberService;

public class NHSConsoleBankapp {

    public static void main(String[] args) {
        MemberService ms = new NHSMemberService(new MemberOracleDao());
        AccountService as = new NHSAccountService(new AccountListDao());

        new StartMenu(as, ms).run();
    }
}
