package basicspringcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by semih on 04.05.2015.
 */
@Controller
public class RequestBodyController {

    @RequestMapping(value = "/request" , method = RequestMethod.GET)
    public String welcome2(ModelMap modelMap) {
        modelMap.addAttribute("requestKey", "Hola!");
        return "request";
    }

    @RequestMapping(value = "/request" , method = RequestMethod.GET , consumes = "application/json")
    public String welcome(ModelMap modelMap , @RequestBody Student student) {
        modelMap.addAttribute("requestKey", "Hola!");
        if (student != null) {
            modelMap.addAttribute("name", student.getName());
            modelMap.addAttribute("lastname", student.getLastname());
            modelMap.addAttribute("age", student.getAge());

        }
        return "request";
    }

    @RequestMapping(value = "/customer" , method = RequestMethod.GET)
    public String customer(ModelMap modelMap , @RequestParam Integer age) {
        modelMap.addAttribute("requestKey", "Hola!");
        modelMap.addAttribute("age", age);

        return "cust";
    }

    @RequestMapping(value = "/request" , method = RequestMethod.POST)
    public String responseBody(ModelMap modelMap , final @RequestBody Student student) {
        modelMap.addAttribute("name", student.getName());
        modelMap.addAttribute("lastname", student.getLastname());
        modelMap.addAttribute("age", student.getAge());
        return "request";
    }

}
