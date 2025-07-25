package knight.brian.spring.boot.aopdemo.aspect;

import knight.brian.spring.boot.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

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
