package aspectorientedprog;

import org.springframework.stereotype.Component;

/**
 * Created by semih on 26.04.2015.
 */
@Component("aop")
public class TargetClassForAspect {

//    Amacım şu bu metodun çalışma zamanını ölçmek istiyorum
//    Görüldüğü üzere bu metod sadece işletme mantığına odaklanmış
//    kendi içinde performansını veya ne kadar süre çalıştığını bilmiyor(kendisi hesaplamıyor)
//    bu hesaplama işleirni AOP ye verdim
    public void doSomething() {

        System.out.println("***Inside the target class");
        System.out.println("***I dont know what method want to do :)");

    }

}
