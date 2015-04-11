package javabasedconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by semih on 12.04.2015.
 */
@Component(value = "stra")
public class StrategyContext {

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
