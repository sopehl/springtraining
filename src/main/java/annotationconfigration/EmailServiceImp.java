package annotationconfigration;

import org.springframework.stereotype.Component;

/**
 * Created by semih on 30.03.2015.
 */
@Component(value = "email")
public class EmailServiceImp implements MessageService {

    @Override
    public void sendMessage() {
        System.out.println("Email service");
    }
}
