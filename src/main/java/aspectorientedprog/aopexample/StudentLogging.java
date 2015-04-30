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

//    Pointcut için olan expression lang. çeşit çeşit olabilir. Burada do ile başlayan metodlara harmanlama yapılması var
    @Pointcut("execution(* aspectorientedprog.aopexample.Student.do*(..))")
    private void doPointCut() {

    }

//    Birden fazla Pointcut referansı seçebiliriz
    @Around("getLogging() || doPointCut()")
    public Object aroundPrintSomething(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(joinPoint.getSignature().toString());
        Object o = joinPoint.proceed();
        logger.info(joinPoint.getTarget().toString());
        return o;
    }

//    O pointcut ve/veya pointcutların çalışmasından önce çalışmasını söylemektedir
    @Before("getLogging()")
    private void beforePrintSomething() {
        System.out.println("Before printSomething()");
    }

}
