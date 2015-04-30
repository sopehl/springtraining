package aspectorientedprog.aopexample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by semih on 30.04.2015.
 */
@Aspect
@Component
public class StudentLoggingAspect {

    private static final Logger logger = Logger.getLogger(StudentLoggingAspect.class.getName());

    @Pointcut("execution(* aspectorientedprog.aopexample.Student.getName(..))")
    private void namePointcut() {

    }

    @Around("namePointcut()")
    public void after(JoinPoint joinPoint) {
       // logger.info(student.getName());
    }


}
