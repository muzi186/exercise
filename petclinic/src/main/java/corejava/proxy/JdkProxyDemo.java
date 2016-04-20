package corejava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ibm on 2016/2/26.
 */
public class JdkProxyDemo {
    public static void main(String... args) {
        Television t = (Television) Proxy.newProxyInstance(Television.class.getClassLoader(), new Class[]{Television.class, DigitalMachine.class},new ProxyHandler(new SanyoTelevision()));

        t.start();
        ((DigitalMachine)t).connect();
        t.play();

        t.switchChannel(10);

        t.stop();
    }
}





