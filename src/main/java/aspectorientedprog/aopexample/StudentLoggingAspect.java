package aspectorientedprog.aopexample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

    @Pointcut("execution(* aspectorientedprog.aopexample.Student.getStudentInfo())")
    private void studentInfo() {

    }

    @Pointcut("execution(* aspectorientedprog.aopexample.Student.getAge())")
    private void exceptionPointcut() {

    }

//    Burada String student parametresi harmanlanacak metodun return türünden olmalıdır.
    @AfterReturning(pointcut = "studentInfo()" , returning = "student")
    public void after(JoinPoint joinPoint , String student) {
        logger.info(joinPoint + student);
    }

    @AfterThrowing(pointcut = "exceptionPointcut()" , throwing = "ex")
    public void afterTrowing(JoinPoint joinPoint , ArithmeticException ex) {
        logger.info(joinPoint + ex.toString());
    }


}
