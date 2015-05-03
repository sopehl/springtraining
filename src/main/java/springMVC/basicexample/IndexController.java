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
    //Handler Mapping denilmektedir.

//    Bu metodumuzun bir ModelMap parametresi bulunmaktadır. Bu parametre şunu sağlamaktadır. Controller le View arasında
//    Veri taşınmasını sağlamaktadır.
//    Burada addAttribute(key,value) ilişkisi kullanılmaktadır. Buradaki key viewda kullanılarak valuelara erişim sağlanır.
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("title", "Welcome to Index page");
//        Buradaki index ise view elementlerinden birinin adıdır. bizim demekki bir tane index adında bir view sağlayıcımız var
//        Bu method çağırıldığında bize bir değer döndürmektedir, burada döndürdüğü değer .jsp sayfasının adıdır
        return "index";
    }


}
