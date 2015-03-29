package annotationconfigration;

/**
 * Created by semih on 30.03.2015.
 */
public class EmailServiceImp implements MessageService {

    @Override
    public void sendMessage() {
        System.out.println("Email service");
    }
}
