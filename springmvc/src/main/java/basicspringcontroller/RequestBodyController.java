package basicspringcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by semih on 04.05.2015.
 */
@Controller
public class RequestBodyController {

    @RequestMapping(value = "/request" , method = RequestMethod.GET)
    public String welcome(ModelMap modelMap) {
        modelMap.addAttribute("requestKey", "Hola!");
        return "request";
    }

    //Burada request isteği için 2 tane metod var bunlardan sadece bir tanesi gelen requeste göre Modellerini
    //Dispatchera göndericekler. Burada kritik olan kısım consumes kısmıdır. Gelen request ile gelen verinin içeriğidir
    //produce ile Spring kullanıcılardan belli içerikte veri alabildiği gibi belli içerikli verileri kullanıcıya sunabilir
    @RequestMapping(value = "/request" , method = RequestMethod.GET , consumes = "application/json" ,produces = "application/json")
    public String welcome(ModelMap modelMap , @RequestBody Student student) {
        modelMap.addAttribute("requestKey", "Hola!");
        if (student != null) {
            modelMap.addAttribute("name", student.getName());
            modelMap.addAttribute("lastname", student.getLastname());
            modelMap.addAttribute("age", student.getAge());

        }
        return "request";
    }

}
