package basicspringcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by semih on 04.05.2015.
 */
@Controller
public class RequestBodyController {

    @RequestMapping(value = "/welcome")
    public String welcome(ModelMap modelMap) {

    }

}
