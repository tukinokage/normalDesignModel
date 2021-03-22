package SingleToneMode;

public class SingleInstance {
    //懒汉，太懒了，来的时候再给你
    private static volatile SingleInstance instance;
    //饿汉,太饿了，一开始就要给
    private static SingleInstance hungryInstance = new SingleInstance();

    public void out(){
        System.out.println("输出");
    }

    /**
     * 双重检测锁
    * */
    public static SingleInstance getInstance(){
        System.out.println("线程：" + Thread.currentThread().getName() +"懒汉");
        if(instance == null){
            synchronized (SingleInstance.class){
                if(instance == null){
                    System.out.println("线程：" + Thread.currentThread().getName() +"懒汉创建");
                    instance = new SingleInstance();
                }
            }
        }

        return instance;
    }

    public static SingleInstance getHungryInstance(){
        System.out.println("饿汉");
        return hungryInstance;
    }




}
