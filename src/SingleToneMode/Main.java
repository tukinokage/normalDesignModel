package SingleToneMode;

public class Main {
    public static void main(String[] args) {
        SingleInstance.getHungryInstance().out();
        new Thread(){
            @Override
            public void run() {
                super.run();
                SingleInstance.getInstance().out();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                super.run();
                SingleInstance.getInstance().out();
            }
        }.start();
    }
}
