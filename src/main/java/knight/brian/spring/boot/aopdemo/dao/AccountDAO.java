package knight.brian.spring.boot.aopdemo.dao;

import knight.brian.spring.boot.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean isVIP);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

}
