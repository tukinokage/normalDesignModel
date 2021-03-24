package PoxyModel;


/*
* 为其他对象提供一个代理以控制对某个对象的访问。
* 代理类主要负责为委托了（真实对象）预处理消息、过滤消息、传递消息给委托类，
* 代理类不现实具体服务，而是利用委托类来完成服务，并将执行结果封装处理。
*
*
* 但是静态代理的缺点：由于代理只能为一个类服务，如果需要代理的类很多，那么就需要编写大量的代理类，比较繁琐。
* */
public class StaticPoxy {

    public static void main(String[] args) {

    }


    public interface HelloInterface{
        void sayHello();
    }

    //被代理类
    public class Hello implements HelloInterface{

        @Override
        public void sayHello() {
            System.out.println("hello!!");
        }
    }

    //代理类
    public class HelloProxy implements HelloInterface{

        @Override
        public void sayHello() {
            HelloInterface hello = new Hello();
            hello.sayHello();
        }
    }
}
