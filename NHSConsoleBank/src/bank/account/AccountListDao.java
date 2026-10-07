package bank.account;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AccountListDao implements AccountDao{

    List<Account> accountDB = new ArrayList<>();
    @Override
    public boolean save(Account a) {
        // TODO 자동 생성된 메소드 스텁
        return accountDB.add(a);
    }

    @Override
    public List<Account> findAll() {
        if (accountDB.size() == 0) return null;
    
        // TODO 자동 생성된 메소드 스텁
        List<Account> accounts = new ArrayList<>();
        for (Account a : accountDB) {
            accounts.add(a); 
        }
        return accounts;    
    }

    @Override
    public Account findByNo(int no) {
        for (Account a : accountDB) {
            if (a.getNo() == no)
                return a;
        }
        
        return null;
    }

    @Override
    public List<Account> findByMemberId(String id) {
        if (accountDB.size() == 0) return null;

        // TODO 자동 생성된 메소드 스텁
        List<Account> accounts = new ArrayList<>();
        for (Account a : accountDB) {
            if (a.getMemberId() != null && a.getMemberId().equals(id)) {
                accounts.add(a);
            }
        }
        return accounts.size() == 0 ? null : accounts;
    }

    @Override
    public boolean update(Account a) {
        Account target = findByNo(a.getNo());
        if (target == null) return false;
        accountDB. remove (target) ;
        accountDB.add(a);
        return true;
    }

    @Override
    public boolean delete(Account a) {
        Account target = findByNo(a.getNo());
        if (target == null) return false;
        return accountDB. remove(target);
    }

    
}