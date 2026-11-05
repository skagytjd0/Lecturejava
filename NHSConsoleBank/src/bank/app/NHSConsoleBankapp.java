package bank.app;

import bank.account.AccountListDao;
import bank.account.AccountService;
import bank.account.NHSAccountService;
import bank.app.menu.StartMenu;
import bank.member.NHSMemberService;
import bank.member.MemberListDao;
import bank.member.MemberService;

public class NHSConsoleBankapp {

	public static void main(String[] args) {
		MemberService ms = new NHSMemberService(new MemberListDao());
		AccountService as = new NHSAccountService(new AccountListDao());
		
		new StartMenu(as, ms).run();
	}
}
