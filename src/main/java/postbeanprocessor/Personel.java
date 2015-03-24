package postbeanprocessor;

/**
 * Created by semih on 24.03.2015.
 */
public class Personel {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init(){
        System.out.println("personel init metodu");
    }

    public void destroy(){
        System.out.println("personel destroy metodu");
    }
}
