package metodenjeksiyon;

/**
 * Created by semih on 16.03.2015.
 */
public abstract class Singleton {

    Prototype prototype;

    public Singleton(){

    }

    public void doSomething(){
        createPrototype().foo();
    }

    public abstract Prototype createPrototype();

}
