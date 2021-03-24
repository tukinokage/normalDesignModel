package PoxyModel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**/
public class ProxyHandler implements InvocationHandler {
    //真实的对象
    private Object obj;

    public ProxyHandler() {
    }

    public ProxyHandler(Object obj) {
        this.obj = obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("我要获取了");
        Object invoke = method.invoke(obj, args);
        System.out.println("我获取完了");
        return invoke;
    }
}
