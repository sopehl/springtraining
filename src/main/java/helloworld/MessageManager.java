package helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by semih on 15.03.2015.
 */
@Component
public class MessageManager {

    //HelloWorldService nesnesi enjekte et anlamına gelmektedir.
    @Autowired
    HelloWorldService service;

    public void printMessage(){
        System.out.println(service.getMessage(  ));
    }
}
