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

//    Not: Burada yapılan annotasyonlu işlemlerin yanı sıra bunlar. XML ilede yapılmakta.
//    http://www.mkyong.com/spring3/spring-aop-aspectj-in-xml-configuration-example/
//    Yukarıdaki linkten xml ile spring aop configuration nasıl yapılır bulabilirim

    private final static Logger logger = Logger.getLogger(StudentLogging.class.getName());
//    Pointcutlarda seperation of concern işleminin hangi metodlara uygulanacağını seçeriz. Yaptığımız iş sadece metodu seçmek
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
