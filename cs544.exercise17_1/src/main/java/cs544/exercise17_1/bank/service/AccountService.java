package cs544.exercise17_1.bank.service;

import java.util.Collection;
import org.hibernate.Transaction;

import cs544.exercise17_1.bank.dao.AccountDAOHibernate;
import cs544.exercise17_1.bank.dao.HibernateUtil;
import cs544.exercise17_1.bank.dao.IAccountDAO;
import cs544.exercise17_1.bank.domain.Account;
import cs544.exercise17_1.bank.domain.Customer;
import cs544.exercise17_1.bank.jms.IJMSSender;
import cs544.exercise17_1.bank.jms.JMSSender;
import cs544.exercise17_1.bank.logging.ILogger;
import cs544.exercise17_1.bank.logging.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AccountService implements IAccountService {

    //private IAccountDAO accountDAO;
    private IAccountDAO accountDAOHibernate;
    private ICurrencyConverter currencyConverter;
    private IJMSSender jmsSender;
    private ILogger logger;

//    public void setAccountDAO(IAccountDAO accountDAO) {
//        this.accountDAO = accountDAO;
//    }

    public void setAccountDAOHibernate(IAccountDAO accountDAOHibernate) {
        this.accountDAOHibernate = accountDAOHibernate;
    }

    public void setCurrencyConverter(ICurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    public void setJmsSender(IJMSSender jmsSender) {
        this.jmsSender = jmsSender;
    }

    public void setLogger(ILogger logger) {
        this.logger = logger;
    }

    public AccountService() {
//        accountDAO = new AccountDAOHibernate();
//        currencyConverter = new CurrencyConverter();
//        jmsSender = new JMSSender();
//        logger = new Logger();
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public Account createAccount(long accountNumber, String customerName) {
        //Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        accountDAOHibernate.saveAccount(account);
        logger.log("createAccount with parameters accountNumber= "
                + accountNumber + " , customerName= " + customerName);

        //tx.commit();
        return account;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void deposit(long accountNumber, double amount) {
        //Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

        Account account = accountDAOHibernate.loadAccount(accountNumber);
        account.deposit(amount);
        accountDAOHibernate.updateAccount(account);
        logger.log("deposit with parameters accountNumber= " + accountNumber
                + " , amount= " + amount);
        if (amount > 10000) {
            jmsSender.sendJMSMessage("Deposit of $ " + amount
                    + " to account with accountNumber= " + accountNumber);
        }

        //tx.commit();
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public Account getAccount(long accountNumber) {
        //Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

        Account account = accountDAOHibernate.loadAccount(accountNumber);

        //tx.commit();
        return account;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public Collection<Account> getAllAccounts() {
        //Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        Collection<Account> accounts = accountDAOHibernate.getAccounts();
        //tx.commit();

        return accounts;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void withdraw(long accountNumber, double amount) {
        //Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

        Account account = accountDAOHibernate.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAOHibernate.updateAccount(account);
        logger.log("withdraw with parameters accountNumber= " + accountNumber
                + " , amount= " + amount);
        //tx.commit();
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void depositEuros(long accountNumber, double amount) {
        //Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

        Account account = accountDAOHibernate.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.deposit(amountDollars);
        accountDAOHibernate.updateAccount(account);
        logger.log("depositEuros with parameters accountNumber= "
                + accountNumber + " , amount= " + amount);
        if (amountDollars > 10000) {
            jmsSender.sendJMSMessage("Deposit of $ " + amount
                    + " to account with accountNumber= " + accountNumber);
        }
        //tx.commit();
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void withdrawEuros(long accountNumber, double amount) {
        //Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

        Account account = accountDAOHibernate.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.withdraw(amountDollars);
        accountDAOHibernate.updateAccount(account);
        logger.log("withdrawEuros with parameters accountNumber= "
                + accountNumber + " , amount= " + amount);

        //tx.commit();
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void transferFunds(long fromAccountNumber, long toAccountNumber,
            double amount, String description) {
        //Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

        Account fromAccount = accountDAOHibernate.loadAccount(fromAccountNumber);
        Account toAccount = accountDAOHibernate.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAOHibernate.updateAccount(fromAccount);
        accountDAOHibernate.updateAccount(toAccount);
        logger.log("transferFunds with parameters fromAccountNumber= "
                + fromAccountNumber + " , toAccountNumber= " + toAccountNumber
                + " , amount= " + amount + " , description= " + description);
        if (amount > 10000) {
            jmsSender.sendJMSMessage("TransferFunds of $ " + amount
                    + " from account with accountNumber= " + fromAccount
                    + " to account with accountNumber= " + toAccount);
        }
        //tx.commit();
    }
}
