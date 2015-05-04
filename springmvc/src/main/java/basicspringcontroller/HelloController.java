package basicspringcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by semih on 03.05.2015.
 */
//    Controller sınıfları MVCdeki controller kısmını temsil etmektedir. Controllerlar bünyesinde kullanıcıdan gelen
//    requestlerin cevaplanmasını sağlayacak metodları barındırmaktadırlar
@Controller
public class HelloController {

    //Kuallanıcı / isteğinde bulunduğunda Dispatcher bizi IndexController sınıfına yönlendirecektir
    //Controller ile istek(/) arasındaki bağı ise @RequestMapping sağlamaktadır. Controller ile adres arasındaki bu bağa
    //Handler Mapping denilmektedir.

    //    Bu metodumuzun bir ModelMap parametresi bulunmaktadır. Bu parametre şunu sağlamaktadır. Controller le View arasında
//    Veri taşınmasını sağlamaktadır.
//    Burada addAttribute(key,value) ilişkisi kullanılmaktadır. Buradaki key viewda kullanılarak valuelara erişim sağlanır.
//    Burada consumes clienttan gelen verir hangi şekilde harcanması gerektiğini söylemekte
    @RequestMapping(value = "/", method = {RequestMethod.GET , RequestMethod.HEAD} , consumes = "application/*")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("message", "Welcome to Hello page");
//        Buradaki index ise view elementlerinden birinin adıdır. bizim demekki bir tane index adında bir view sağlayıcımız var
//        Bu method çağırıldığında bize bir değer döndürmektedir, burada döndürdüğü değer .jsp sayfasının adıdır
        return "hello";
    }

    @RequestMapping(value = "/welcome" , method = RequestMethod.GET)
     public String welcome(ModelMap modelMap) {
        modelMap.addAttribute("message", "You are on the Welcome page");
        return "hello";
    }

    //Ağaşıdaki method sırayla şunu denemtedir
    //bir redirect request ve o requestin parametreleri gelirse
    //http://localhost:8080/redirect?pageKey=pagename bu şekildeki gibi
    //doğrudan yönlendirilecek sayfaya gönder
    //@RequestMapping annotasyonu metodların parametreleri bir kullanicinin requesti ile gelen verilerdir
    //Burada @RequestParam metodu ise pageKey key inin değerini pageName e atayıp onu metodun gövdesinde kullanıp
    //daha sonra gerekli verilerin DispatcherServlete geri getirilmesini sağlamaktadır
    @RequestMapping(value = "/param" , method = RequestMethod.GET)
    public String redirectToPage(final ModelMap modelMap , @RequestParam("pageKey") String pageValue) {
//        Burada önemli noktalardan biride şudur:
//        Eğerki kullanıcı parametresi olmayan bir request atarsa bu metodun işlevini yerine getiremez
//        RequestParam esine istiyaç duymadan çalışmasını istiyorsak eğer. Annotasyonumuzu şu şekilde kullanmalıyız
//        @RequestParam("pageKey" , require = false) şeklinde olmalıdır
        modelMap.addAttribute("message", "Your pagekey value is :" + pageValue);
        return "hello";
    }

    //    Burada request teki userid ile @PathVariable içindeki userid birbirleri ile bind edilmiştir
//    @PathVariable annotasyonu sayesinde bir request pathindeki değerlerin bir controller metoduna parametre
//    geçmek mümkündür. Örneğin: http://localhost/tast/870 burada userid değeri 870 dir ve bu değer
//    metodun parametresi olan userid'ye geçilmiştir. Artık pathteki değer metodun içinde kullanılabilir
    @RequestMapping(value = "/path/{userid}", method = RequestMethod.GET)
    public String getUserTaskList(final ModelMap modelMap, @PathVariable(value = "userid")String userid) {
        //Buradaki idye sahip kullanıcının tasklarını bir listeye atabilirim.
        //Istenilen şekilde kullanabilirim
        modelMap.addAttribute("message", "Your user id :" + userid);
        return "hello";
    }

}
