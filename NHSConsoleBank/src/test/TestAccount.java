package test;

import java.util.List;

import bank.account.Account;
import bank.account.AccountDao;
import bank.account.AccountListDao;

public class TestAccount {
    public static void main(String[] args) {
        testAccountDao();
    }

    public static void testAccountDao() {
        AccountDao adao = new AccountListDao();

        System.out.println(">>> 계좌 추가 및 목록");
        adao.save(new Account(1111, "1111", "hyejeong", 10000));
        adao.save(new Account(2222, "2222", "curi", 50000));
        adao.save(new Account(3333, "1111", "hyejeong", 0));
        List<Account> alist = adao.findAll();
        printAccountList(alist);

        System.out.println(">>> 계좌번호로 계좌 찾기");
        Account acc = adao.findByNo(1111);
        System.out.println(acc);

        System.out.println(">>> 회원 ID로 계좌 찾기");
        List<Account> memberAccounts = adao.findByMemberId("hyejeong");
        printAccountList(memberAccounts);

        System.out.println(">>> 비번변경");
        acc.setPassword("1234");
        adao.update(acc);
        printAccountList(adao.findAll());

        System.out.println(">>> 잔액변경");
        acc.setBalance(20000);
        adao.update(acc);
        printAccountList(adao.findAll());

        System.out.println(">>> 계좌 삭제");
        adao.delete(adao.findByNo(3333));
        printAccountList(adao.findAll());
    }

    public static void printAccountList(List<Account> alist) {
        for (Account a : alist) {
            System.out.println(a);
        }
    }
}