package annotationconfigration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by semih on 30.03.2015.
 */
@Component(value = "student")
public class Student {

    //@Autowired ta require = true default değerdir
    @Autowired
    private MessageService service;

    //@Autowired kullanmazsak NullPointer alırız.
    @Autowired
    private Lesson lesson;


    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public MessageService getService() {
        return service;
    }

    public void setService(MessageService service) {
        this.service = service;
    }

    public void aboutMessage(){
        service.sendMessage();
    }

    public void aboutLesson(){
        lesson.lessonMethod();
    }
}
