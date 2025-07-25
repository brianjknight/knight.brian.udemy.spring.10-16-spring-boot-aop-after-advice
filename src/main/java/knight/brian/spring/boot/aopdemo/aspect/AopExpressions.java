package knight.brian.spring.boot.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AopExpressions {

    // Pointcut Declaration to match any class and method (zero or more args) in the dao Package
    @Pointcut("execution(* knight.brian.spring.boot.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    // Pointcut Declaration to match dao getters
    @Pointcut("execution(* knight.brian.spring.boot.aopdemo.dao.*.get*(..))")
    public void getter() {}

    // Pointcut Declaration to match dao setters
    @Pointcut("execution(* knight.brian.spring.boot.aopdemo.dao.*.set*(..))")
    public void setter() {}

    // Combining declarations dao methods that are NOT getters or setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterNoSetter() {}

}
