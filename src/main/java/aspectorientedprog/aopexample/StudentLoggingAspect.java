package aspectorientedprog.aopexample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by semih on 30.04.2015.
 */
@Aspect
@Component
public class StudentLoggingAspect {

    private static int methodRunningTime;
    private static final Logger logger = Logger.getLogger(StudentLoggingAspect.class.getName());

    @Pointcut("execution(* aspectorientedprog.aopexample.Student.getStudentInfo())")
    private void studentInfo() {

    }

    @Pointcut("execution(* aspectorientedprog.aopexample.Student.getAge())")
    private void exceptionPointcut() {

    }

    @Pointcut("execution(* aspectorientedprog.aopexample.Student.getParameter(..))")
    private void getParameterPointcut() {

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

//    Bir method ne döndürürse döndürsün ondan sonra çalışacak olan advice ı belirlemektedir
    @After("studentInfo()")
    public void afterAdvice() {
        methodRunningTime++;
        logger.info("This method run "+ methodRunningTime+" times");
    }

//    Advice target metodların parametreleri nasıl kullnıldığını göstermektedir
    @AfterReturning(value = "getParameterPointcut()" ,returning = "str")
    public void parametersAdvice(JoinPoint joinPoint , String str) {
        Object[] obj = joinPoint.getArgs();
        logger.info(obj[0].toString());
        logger.info(str);
    }

//    Aşağıdaki expression getParameterPointcut pointcut ve arguman olarak String alan metodu kullan demektedir
//    Advice ile birlikte çalışan metodun bizzat parametresini burada advice içinde bu şekildede kullanabiliriz
    @Before("getParameterPointcut() && args(string)")
    public void beforeParameters(String string) {
        logger.info("Before advice parameter name: "+ string);
    }


}
