package annotationconfigration;

import org.springframework.stereotype.Component;

/**
 * Created by semih on 30.03.2015.
 */
//burada Component annotasyonu kullanılarak bu classın bir bean olduğunu söyluyoruz. aynı <bean></bean> tanımladığımız gibi.
@Component(value = "sms")
public class SMSService implements MessageService {

    @Override
    public void sendMessage() {
        System.out.println("Sms Service");
    }
}
