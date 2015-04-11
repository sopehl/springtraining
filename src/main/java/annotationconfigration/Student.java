package annotationconfigration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by semih on 30.03.2015.
 */
//  javada bir sınıfın bean olarak algılanabilmesi için onun @Component annotasyonu ile tanımlanmış olması gerekmektedir.
//  buradaki value kısmında kullanılan student ibaresi xml yapısında bir bean için kullanılan id veya name ile eş değerdir
@Component(value = "student")
public class Student {

    //@Autowired ta require = true default değerdir
    @Autowired
    //@Qualifier annotasyonu sayesinde buraya hangi MessageService implementasyonu enjekte edilecek ona karar vermiş olduk. Buradaki value değeri xml dosyasındaki
    //MessageService implementasyonlarından birinin idsidir.
    @Qualifier(value = "email")
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
