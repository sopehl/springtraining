package exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
//    Responsestatus serverın requestlere yaptığı responselar hakkında bilgi sağlamaktadır
//    Örn: Responsestatus eğer ki 200 ise gönderilen request sorunsuz cevaplandı anlamına gelmektedir - Status değeri 302
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
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
