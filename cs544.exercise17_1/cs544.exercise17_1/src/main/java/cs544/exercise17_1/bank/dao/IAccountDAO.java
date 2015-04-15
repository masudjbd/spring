package cs544.exercise17_1.bank.dao;

import java.util.Collection;

import cs544.exercise17_1.bank.domain.Account;



public interface IAccountDAO {
	public void saveAccount(Account account);
	public void updateAccount(Account account);
	public Account loadAccount(long accountnumber);
	public Collection<Account> getAccounts();
}
