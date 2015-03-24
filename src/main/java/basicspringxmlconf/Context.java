package basicspringxmlconf;

/**
 * Created by semih on 15.03.2015.
 */
public class Context {


    //Context classı bir tane strategy tipinden classa bağımlıdır.
    Strategy strategy;

    //Mevcut bağımlılık burada yapılandırıcı ile enjekte edilmektedir.
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeOperation(int x , int y){
        return strategy.doOperation(x,y);
    }
}
