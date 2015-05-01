package aspectorientedprog.dynamicextending;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by semih on 01.05.2015.
 */
@Aspect
@Component
public class ClassMethodAdderAspect{

    //Aşağıdaki bağımlılık bir interface olması gerekmektedir. valueda dinamik olarak genişletilecek class belirlenir
    //defaultImpl ile Genişletme işleminin hangi implementasyon ile yapılacağını belirleriz
    @DeclareParents(value = "aspectorientedprog.dynamicextending.Triangle" , defaultImpl = ShapeCalculationImp.class)
    public static ShapeCalculation mixin;
    
}
