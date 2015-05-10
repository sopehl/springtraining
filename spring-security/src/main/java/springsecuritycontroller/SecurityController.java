package springsecuritycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by semih on 10.05.2015.
 */
@Controller
public class SecurityController {

    @RequestMapping(value = {"/"}, method = {RequestMethod.GET, RequestMethod.HEAD})
    public String indexHandler(ModelMap modelMap) {
        modelMap.addAttribute("title", "Welcome The Spring Security Page");
        return "index";
    }

//    Korunan request aşağıdadır
    @RequestMapping(value = "/secure/home" , method = RequestMethod.GET)
    public String security(ModelMap modelMap) {
        modelMap.addAttribute("message", "You are in the secured page");
        return "secured";
    }

//    Korunan requeste gidilmek istendiğinde /login requesti atılmaktadır
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

}
