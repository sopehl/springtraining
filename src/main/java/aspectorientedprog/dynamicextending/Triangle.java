package aspectorientedprog.dynamicextending;

import org.springframework.stereotype.Component;

/**
 * Created by semih on 01.05.2015.
 */
@Component("triangle")
public class Triangle implements Shape{

    @Override
    public void calculateArea() {
        System.out.println("Calculated the Area");
    }

    /*@Override
    public void calculatePerimater() {
        System.out.println("Calculated the primater");
    }*/

}
