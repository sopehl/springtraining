package javabasedconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by semih on 12.04.2015.
 */
// Aşağıdaki class birşeylerin enjekte edileceği classtır. Configuration classının hedefinde burası vardır
// Aşağıdaki annotasyon şunu demektedir. Bu bir bean ve bunun id'si(tıpkı xml dosyalarındaki gibi) "strategy" dir.
@Component(value = "strategy")
public class StrategyContext {

    // Configuration dosyasından buraya bir enjekte işlemi yap anlamına gelmektedir.
    @Autowired
    // @Qualifier annotasyonu spring hangi implementasyonu enjekte edeceğini bilemediğinde ona yol göstermemizi sağlamaktadır.
    // configuration classlarında beanların kimlikleri metod isimleridir ve qualifier bu metod isimlerine göre hangi implementasyon olduğunu bilir
    // Conf classımızda 2 tane Strategy tipinden bean var(2.si import edilerek geliyor), burada çarpma işlemi enjekte edilmiş
    // Çünkü value değerine MullStrategy objesi döndüren beanın metod adını geçtik, böylece hangi implementasyon olduğu belli oldu
    @Qualifier(value = "getMull")
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
