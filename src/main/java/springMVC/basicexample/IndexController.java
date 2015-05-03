package springMVC.basicexample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    //Ağaşıdaki method sırayla şunu denemtedir
    //bir redirect request ve o requestin parametreleri gelirse
    //http://localhost:8080/redirect?pageKey=pagename bu şekildeki gibi
    //doğrudan yönlendirilecek sayfaya gönder
    //@RequestMapping annotasyonu metodların parametreleri bir kullanicinin requesti ile gelen verilerdir
    //Burada @RequestParam metodu ise pageKey key inin değerini pageName e atayıp onu metodun gövdesinde kullanıp
    //daha sonra gerekli verilerin DispatcherServlete geri getirilmesini sağlamaktadır
    @RequestMapping(value = "/redirect" , method = RequestMethod.GET)
    public String redirectToPage(final ModelMap modelMap , @RequestParam("pageKey") String pageName) {
//        Burada önemli noktalardan biride şudur:
//        Eğerki kullanıcı parametresi olmayan bir request atarsa bu metodun işlevini yerine getiremez
//        RequestParam esine istiyaç duymadan çalışmasını istiyorsak eğer. Annotasyonumuzu şu şekilde kullanmalıyız
//        @RequestParam("pageKey" , require = false) şeklinde olmalıdır
        return pageName;
    }

}
