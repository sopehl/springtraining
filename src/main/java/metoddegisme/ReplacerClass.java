package metoddegisme;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Created by semih on 16.03.2015.
 */
public class ReplacerClass implements MethodReplacer {


    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {

        // args[0] doSomething metodundaki parametredir.
        String str = ((String) args[0])+" World ";
        // args[1] doSomething metodundaki 2. parametredir.
        Object i = args[1];
        System.out.println(str+i);
        return str;

    }
}
