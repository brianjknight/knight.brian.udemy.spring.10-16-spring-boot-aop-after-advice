package knight.brian.spring.boot.aopdemo;

import knight.brian.spring.boot.aopdemo.dao.AccountDAO;
import knight.brian.spring.boot.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
//			demoTheBeforeAdvice(accountDAO, membershipDAO);
			demoTheAfterReturningAdvice(accountDAO);
		};
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = accountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		Account myAccount = new Account();
		myAccount.setName("Brian");
		myAccount.setLevel("Red");
		accountDAO.addAccount(myAccount, true);
		accountDAO.doWork();

		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		membershipDAO.addMember();
		membershipDAO.goToSleep();
	}
}
