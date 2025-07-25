package knight.brian.spring.boot.aopdemo.aspect;

import knight.brian.spring.boot.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @AfterReturning(
            pointcut = "execution(* knight.brian.spring.boot.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n=====>>> result is: " + result);
    }

    @Before("knight.brian.spring.boot.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterNoSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("=====>>> Executing @Before on a DAO method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        System.out.println("args for method: ");
        for (Object obj : args) {
            System.out.println(obj);
            // downcast and print Account specific stuff
            if (obj instanceof Account theAccount) {
                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }

}
