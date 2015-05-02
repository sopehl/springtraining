package springMVC.basicexample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by semih on 02.05.2015.
 */
@Controller
public class IndexController {

    //Kuallanıcı / isteğinde bulunduğunda Dispatcher bizi IndexController sınıfına yönlendirecektir
    //Controller ile istek(/) arasındaki bağı ise @RequestMapping sağlamaktadır. Controller ile adres arasındaki bu bağa
//    Handler Mapping denilmektedir.
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("title", "Welcome to Index page");
        return "index";
    }

}
