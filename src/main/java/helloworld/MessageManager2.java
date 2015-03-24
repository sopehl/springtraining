package helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by semih on 15.03.2015.
 */
@Component
public class MessageManager2 {

    @Autowired
    HelloWorldService service;

    void print(){
        System.out.println(service.getMessage());
    }

}
