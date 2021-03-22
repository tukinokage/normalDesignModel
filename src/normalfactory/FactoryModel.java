package normalfactory;

//泛型工厂模式
public class FactoryModel {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Factory hotFruitFactory = new HotFruitFactory();
        IFurit banana = hotFruitFactory.create(Banana.class);
        banana.eat();

        Factory temperateFruitFactory = new TemperateFruitFactory();
        IFurit kiwiFruit = temperateFruitFactory.create(KiwiFruit.class);
        kiwiFruit.eat();
    }

    interface IFurit{
        void eat();
    }

   static abstract class HotFruit implements IFurit{
        HotFruit(){
            System.out.println("热带水果");
        }
    }

    static abstract class TemperateFruit implements IFurit{
        TemperateFruit(){
            System.out.println("温带水果");
        }
    }

    static class Banana extends HotFruit{

        @Override
        public void eat() {
            System.out.println("吃香蕉");
        }
    }

    static class KiwiFruit extends TemperateFruit{

        @Override
        public void eat() {
            System.out.println("吃猕猴桃");
        }
    }
    
    static abstract class Factory{
         Factory(){
            System.out.println("开始生产不同工厂");
        }
        abstract <T extends IFurit>T  create(Class<T> clazz) throws IllegalAccessException, InstantiationException;
    }

    static class HotFruitFactory extends Factory{
        HotFruitFactory(){
            System.out.println("热带水果厂");
        }
        @Override
        <T extends IFurit> T create(Class<T> clazz) throws IllegalAccessException, InstantiationException {
            if(HotFruit.class.isAssignableFrom(clazz)){
                return clazz.newInstance();
            }else {
                throw new IllegalArgumentException("没有该种水果");
            }
        }
    }

    static class TemperateFruitFactory extends Factory{
        TemperateFruitFactory(){
            System.out.println("温带水果厂");
        }
        @Override
        <T extends IFurit> T create(Class<T> clazz) throws IllegalAccessException, InstantiationException {
            if(TemperateFruit.class.isAssignableFrom(clazz)){
                return clazz.newInstance();
            }else {
                throw new IllegalArgumentException("没有该种水果");
            }
        }
    }




}
