package javaTest.reflectProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by syh20 on 2016/8/6.
 */
public class ProxyHandler implements InvocationHandler {
    private Object target;

    public ProxyHandler(Object targetObj){
        this.target = targetObj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理：原方法运行前");
        Object obj = method.invoke(target,args);
        System.out.println("代理：原方法运行后");
        return  obj;
    }

    public static void main(String[] args) {
        TargetImpl target = new TargetImpl();
        ProxyHandler proxy = new ProxyHandler(target);
        TargetInterface proxyInstance = (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),proxy);
        proxyInstance.targetMethod1(1);
        proxyInstance.targetMethod2(2);
    }
}
