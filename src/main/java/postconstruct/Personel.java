package postconstruct;

import javax.annotation.PostConstruct;

/**
 * Created by semih on 25.03.2015.
 */
public class Personel {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // init metodunun 3. kullanım şeklidir. 3 kullanım bir arada olursa(InitializingBean interface ve init-metod)
    // en öncelikli kullanım bu annotasyondur.
    // configrasyon dosyasında bu annotasyonun kullanıldığı belirtilmelidir
    @PostConstruct
    public void init(){
        System.out.println("personel init metod.");
    }
}
