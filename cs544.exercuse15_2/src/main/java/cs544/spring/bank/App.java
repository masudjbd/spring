package cs544.spring.bank;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cs544.spring.bank.domain.Account;
import cs544.spring.bank.domain.AccountEntry;
import cs544.spring.bank.domain.Customer;
import cs544.spring.bank.service.IAccountService;

public class App {
	public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext(
				"springserviceconfig.xml");	
	}

}
