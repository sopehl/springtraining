#####AOP

-   Bir metodun sadece kendi iş mantığına bağlı çalışması gerekmektedir.
-   Peki bir metod kendi iş mantığı dışında neler yapabilir? Bu şu demek metodun içerisinde yapması gereken işin
yanında başka işlerde yapıyor. Örnek vericek olursak para-havale işlemini verelim. Bizimde bir tane
paraHavaleEt() diye metodumuz olsun. Bu metodun yapması gereken iş mantığının içinde havale eden kişinin hesabından,
havale edilecek kadar parayı eksilt sonra havale edilecek kişinin parasına bunu ekle. İşletme mantığımız çok basit.
Biraz daha incelersek eğer metodumuz içinde bir Loglama işlemi,Transaction yönetimi, performans bilgileri gibi bilgiler
alabilir. Bu tarz işletme mantığının dışında kalan fonksiyonlara **cross cutting concern** denmektedir ve bir metod için
işletme mantığının dışında yapabileceği işlere örnek olarak aşağıdakileri örnek verebiliriz(jenerik fonksiyonlar)
    -   Loglama
    -   Transaction yönetimi
    -   Güvenlik
    -   Cache kullanımı
    -   Hata yönetimi
    -   Performans ölçümü
    -   iş kuralları uygulanması
    
-   AOP bizlere şunu sağlamaktadır. paraHavaleEt metodunda bulunan **jenerik metodlar** olmasın, metodumuz sadece kendi
işletme mantığına kavuşsun, kodun okunurluğu artsın. Diğer işlemler(jenerik fonk.) fonksiyon çağırılmadan önce ve sonra çalışsın.
Bu işlemi sağlayan yapı AOP'dir

-   Böylece kodun okunurluğu ve gelişimine önemli ölçüde katkı sağlayan bu ayrıştırmaya seperation of concern
(çalışma sahalarının ayrışması) denilmektedir.

-   Önemli terminolojilerden birtaneside buradaki **Transaction, Logging, Caching, Performans Ölçümü veya Hata yönetimi**
gibi işlemlere AOP dilinde **aspect** denilmektedir

-   java dünyasında önemli bir AOP frameworku AspectJ'dir. AspectJ, aspectlerin **bytecode** seviyesinde iş mantığını taşıyan
kodlar ile birleşmesi(harmanlanmasını) sağlamaktadır.

-   AOP kavramlarından bir taneside advicelardır. **Advicelar** koşturmak istediğimiz loglama, transaction veya caching gibi
jenerik fonksiyonlar olarak tanımlarız.

-   **Aspect** hangi jenerik fonksiyonun nerede ve ne zaman kosturulacağını tanımlar.