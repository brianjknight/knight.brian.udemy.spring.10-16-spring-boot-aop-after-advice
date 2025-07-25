package knight.brian.spring.boot.aopdemo.dao;

import knight.brian.spring.boot.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);

    void addAccount(Account account, boolean isVIP);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}
