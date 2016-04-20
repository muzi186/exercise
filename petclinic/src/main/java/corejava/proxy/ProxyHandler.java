package corejava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by ibm on 2016/2/26.
 */
public class ProxyHandler implements InvocationHandler {
    private Object proxiedObject;
    public ProxyHandler(Object proxied){
        proxiedObject = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        return method.invoke(proxiedObject,args);
    }
}
