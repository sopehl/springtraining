package aspectorientedprog.aopexample;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by semih on 29.04.2015.
 */
@Aspect
@Component
public class StudentLogging {

    private final static Logger logger = Logger.getLogger(StudentLogging.class.getName());

    @Pointcut(value = "execution(* aspectorientedprog.aopexample.Student.printSomething())")
    private void getLogging() {

    }

    @Around("getLogging()")
    public Object aroundPrintSomething(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("before printing somethings");
        Object o = joinPoint.proceed();
        logger.info("after printing somethings");
        return o;
    }

    /*@Before("getLogging()")
    public void beforePrintSomethinf() {
        System.out.println("Something");
    }
*/
}
