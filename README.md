### springtraining

-   Spring ile ilgili basit örnekler içermektedir.

-   Spring modülleri

![spring modules] (http://www.tutorialspoint.com/images/spring_architecture.png)

-   Spring Yaşam döngüsü

![Spring yaşam döngüsü] (http://emprovise.comuf.com/slides/content/images/springbasics/Slide23_Content_Placeholder_5.png)

> Faydalı linkler:
>> [tutorialspoint](http://www.tutorialspoint.com/spring/)
>> [Pratik Spring Core - Özcan Acar](http://www.pratikprogramci.com/urun/pratik-spring-core-ozcan-acar/)

-   Springde kullanılan temel annotasyonlar(org.springframework.sterotype)
    -   @Controller
    -   @Repository
    -   @Component
    -   @Service

-   Datasource konfigrasyon yöntemleri:(Her birinin kendine göre özellikleri var)
    -   JDBC driver ile(Büyük projelerde kullanılması tavsiye edilmiyor)
    -   JNDI kullanarak
    -   DBCP kullanarak [DBCP ref.](http://commons.apache.org/dbcp/), [c3po ref.](http://www.mchange.com/projects/c3p0/)

-   Spring platform bağımsız transaction managers

![spring-trans-managers](http://www.injavawetrust.com/wp-content/uploads/spring-transaction-manager.png)

-   Java dünyasında en tanınmış ORM frameworkleri
    -   Hibernate
    -   EclipseLink
    -   OpenJPA