package javabasedconfiguration;

/**
 * Created by semih on 12.04.2015.
 */
public class AddStrategy implements Strategy {

    @Override
    public void execute(int a, int b) {
        System.out.println("toplam:" + (a+b));
    }
}
