package basicspringcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by semih on 05.05.2015.
 */
@Controller
@RequestMapping("/do")
public class InternalAndExternalDirect {

    @RequestMapping(method = RequestMethod.GET)
    public RedirectView doSomething(final ModelMap modelMap) {
        //burada ise önemli keyword redirect bu sayede do/done şeklinde bir request atabiliriz
        //RedirectView kullanılarakta bu işlem yapılmaktadır,Bu sınıf sayesinde redirect yaparken parametreleride
        //redirect edilen yerde kullanabiliriz

        /*@RequestMapping(method = RequestMethod.GET)
        public RedirectView redirect(final ModelMap model)
        throws IOException {
            RedirectView redirectView =
                    new RedirectView("rental/list");
            redirectView.addStaticAttribute("errorMessage",
                    "error1");
            return redirectView;
        }*/

        RedirectView redirectView =
                new RedirectView("do/done");
        redirectView.addStaticAttribute("name" , "Okan");
        return redirectView;
        //return "redirect:do/done";
    }

    //for http://localhost:8080/do/done
    @RequestMapping(value = "/done" , method = RequestMethod.GET)
    public String done(ModelMap modelMap , @RequestParam String name) {
        modelMap.addAttribute("done", "Doneeeee !!");
        modelMap.addAttribute("name", name);
        //return ile bir yönlendirme işlemi yaptık bu bir done.jsp sayfasına işaret etmektedir.
        //burada yapılan işleme internal direct denilmektedir
        return "done";
    }

}
