package knight.brian.spring.boot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("knight.brian.spring.boot.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterNoSetter()")
    public void logToCloudAsync() {
        System.out.println("=====>>> Logging to cloud");
    }

}
