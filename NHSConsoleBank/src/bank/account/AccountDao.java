package bank.account;

import java.util.List;

public interface AccountDao {
    List<Account> findByMemberId(String id);
    boolean update(Account a);
    boolean delete(Account a);
    boolean save(Account a);
    List<Account> findAll();
    Account findByNo(int no);

}