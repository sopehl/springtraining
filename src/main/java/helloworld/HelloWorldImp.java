package helloworld;

/**
 * Created by semih on 15.03.2015.
 */
public class HelloWorldImp implements HelloWorldService{

    @Override
    public String getMessage() {
        return "Hello World with Spring";
    }
}
