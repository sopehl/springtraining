package springexpressionlang;

/**
 * Created by semih on 29.03.2015.
 */
public class Customer {

    private int value;
    private String name;
    private  boolean x;

    public boolean isX() {
        return x;
    }

    public void setX(boolean x) {
        this.x = x;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
