package exceptionhandling;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

/**
 * Created by semih on 07.05.2015.
 */
@Controller
@RequestMapping(value = "/ex")
public class ExceptionHandlingController {

    @RequestMapping(method = RequestMethod.GET)
    public String toError(ModelMap modelMap) throws IOException {
//        Burada kendiliğinden bir exception oluşturuyorum ve bu durumu aşağıda işliyorum
        throw new IOException("Got IOException");

    }

//    burası şunu demektedir bu controllerda bir IOException olursa aşağıdaki metodu çağır denemktir
    @ExceptionHandler(IOException.class)
    public RedirectView handleIOException(IOException e) {
//        Burada redirect işlemi yapmaktayız ve url i aşağıdaki gibidir
        RedirectView redirectView = new RedirectView("/ex/ioex");
//        buradaki urlye parametre eklemekteyiz. bu parametreler yukarıdaki url ile aktarılmaktadır
        redirectView.addStaticAttribute("errorMessage", e.getMessage());
//        En son bu objeyi döndürüyoruz.
        return redirectView;
    }

//    RedirectView bizi ex/ioex requesti atıyor ve aşağıdaki metod ile bu request handling işlemi yapılıyor
    @RequestMapping(value = "/ioex", method = RequestMethod.GET)
    public String error(ModelMap modelMap , @RequestParam("errorMessage") String errorMassage) {
//        Bastinden gelen parametreyi birtane model attributelerine key-value olarak ekliyoruz
        modelMap.addAttribute("errorMessage", errorMassage);
        return "error";
    }

}
