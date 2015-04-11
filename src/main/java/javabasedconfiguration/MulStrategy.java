package javabasedconfiguration;

/**
 * Created by semih on 12.04.2015.
 */
public class MulStrategy implements Strategy {

    @Override
    public void execute(int a, int b) {
        System.out.println("Çarpım:"+ (a*b));
    }
}
