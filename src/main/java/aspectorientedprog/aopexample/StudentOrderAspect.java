package aspectorientedprog.aopexample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by semih on 01.05.2015.
 */

@Aspect
@Component
@Order(2)//Order sayesinde bu aspectin sırasını 2 olarak belirledik
public class StudentOrderAspect {

    private static final Logger logger = Logger.getLogger(StudentOrderAspect.class.getName());

    @Pointcut("execution(* aspectorientedprog.aopexample.Student.joinPointForOrder(..))")
    private void getOrderedPointcut() {
    }

    @Before("getOrderedPointcut()")
    private void orderAdvice() {
        System.out.println("Order 2");
    }

    @Pointcut("execution(* aspectorientedprog.aopexample.Student.joinPointForOrder(..))")
    private void getOrderedPointcut2() {
    }

    @Before("getOrderedPointcut2()")
    private void orderAdvice2() {
        System.out.println("Order 3");
    }

    @Before("getOrderedPointcut()")
    private  void orderAdvice3(JoinPoint joinPoint) {
        logger.info(joinPoint.getSignature().getName());
    }

}
