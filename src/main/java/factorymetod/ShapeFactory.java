package factorymetod;

/**
 * Created by semih on 23.03.2015.
 */
public class ShapeFactory {

    static Shape shape;

    public static Shape createShape(ShapeType shapeType){

        if(shapeType == ShapeType.CIRCLE)
            shape = new Circle();
        else if (shapeType == ShapeType.TRIANGLE)
            shape = new Triangle();

        return shape;
    }
}
