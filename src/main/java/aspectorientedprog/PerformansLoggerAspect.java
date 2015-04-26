package aspectorientedprog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by semih on 26.04.2015.
 */
//    Bu annotasyon ile bunun bu classın bir aspect olduğunu belilirmekteyim.
//    @Aspect annotasyonu AspectJ frameworkun bir annotasyonudur
//    Aspect tanımına uygun olarak profile metodunda jenetik işlemler(currentTimeMillis gibi) ve
//    joinPoint kullandık. Aspectler sayesinde metodlarımızı daha okunur ve anlaşılır yapabiliriz
@Aspect
//     Springin aspectleri anlayabilmesi için @Component annotasyonunu kullanmamız gerekmektedir
//     Burayı bir bean olarak springe belirmemiz gerekmektedir
@Component
public class PerformansLoggerAspect {

//    Bu annotation bizim jeneriklerimizi harmanlayacağımız, işletme mantığının olduğu metodu belirtmektedir
//    Aspect bu annotasyon sayesinde nereye hangi metoda bu harmanlamayı yapacağını bilmektedir
    @Around("execution(* aspectorientedprog.TargetClassForAspect.doSomething(..))")
    public Object profile(ProceedingJoinPoint joinPoint) throws Throwable {
//        Basit bir metodun çalışma zamanını anlamaya çalıştığımız kod
        long start = System.currentTimeMillis();
        System.out.println("Metod öncesi" + joinPoint.getSignature());
        System.out.println(joinPoint.getKind());
        System.out.println(joinPoint.getSourceLocation().getWithinType().toString());
        System.out.println(joinPoint.getTarget().toString());
//         Target classımızda(TargetClassForAspect) bulunan metod tam burada çalıştırılıyor
        Object object = joinPoint.proceed();

        System.out.println("Metod sonrası");
//        geçen süre(elapsed time) hesaplaması ise aşağıda yapıldı
        long elapsedTİme = System.currentTimeMillis() - start;
        System.out.println("Metod kosturma zamanı :" + elapsedTİme + " milliseconds.");
        return object;
    }

}
