package normalfactory;

public class NormalFactory {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        FruitFactory appFactory = new FruitFactory<IFruit>();
        IFruit app = (IFruit) appFactory.getInstance(Apple.class);
        app.eat();

        IFruit banana = (IFruit) appFactory.getInstance(Banana.class);
        banana.eat();

    }

    interface IFruit{
        void eat();
    }

    static class Apple implements IFruit {

        @Override
        public void eat() {
            System.out.println("苹果要削皮");
            System.out.println("开始吃苹果");
        }
    }

    static class Banana implements IFruit {
        @Override
        public void eat() {
            System.out.println("香蕉不削皮");
        }
    }

    static class FruitFactory<T extends IFruit>{
        FruitFactory(){
        }

        public <T> T getInstance(Class<T> generClass) throws IllegalAccessException, InstantiationException {
            T fruit = generClass.newInstance();
            System.out.println("生产水果中...");
            return fruit;
        }

    }
}

