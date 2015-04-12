package javabasedconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by semih on 12.04.2015.
 */
// Aşağıdaki class birşeylerin enjekte edileceği classtır. Configuration classının hedefinde burası vardır
// Aşağıdaki annotasyon şunu demektedir. Bu bir bean ve bunun id'si(tıpkı xml dosyalarındaki gibi) "strategy" dir.
@Component(value = "strategy")
public class StrategyContext {

    //Configuration dosyasından buraya bir enjekte işlemi yap anlamına gelmektedir.
    @Autowired
    public Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(int a,int b){
        strategy.execute(a,b);
    }
}
