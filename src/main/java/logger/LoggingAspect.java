package logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.lab2.*.*(..))||execution(* logger.*.*(..))")
    public void allMeth() {}

    @Before("allMeth()")
    public void beforeLog(JoinPoint jp){
        System.out.println(jp.getSignature()+" started it's work");
    }
    @AfterReturning("allMeth()")
    public void afterLog(JoinPoint jp){
        System.out.println(jp.getSignature()+" ended it's work");
    }
}
