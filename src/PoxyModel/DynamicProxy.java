package PoxyModel;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 利用反射机制在运行时创建代理类
 *简易实现
 *
 * 通过实现 InvocationHandler 接口创建自己的调用处理器；
 * 通过为 Proxy 类指定 ClassLoader 对象和一组 interface 来创建动态代理类；
 * 通过反射机制获得动态代理类的构造函数，其唯一参数类型是调用处理器接口类型；
 * 通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数被传入。
 *
 * @Create by shay
 * */
public class DynamicProxy {
    public static void main(String[] args) {
        People teacher = new Teacher();

        InvocationHandler handler = new ProxyHandler(teacher);
        //负责代理的类
        People people = (People) Proxy.newProxyInstance(handler.getClass().getClassLoader(), teacher.getClass().getInterfaces(), handler);
        people.doSomething();
        people.eat();
    }


    public static class Teacher implements People{

        @Override
        public void doSomething() {
            System.out.println("老师教书");
        }

        @Override
        public void eat() {
            System.out.println("老师吃饭");
        }
    }

    interface People{
        void doSomething();
        void eat();
    }


}
