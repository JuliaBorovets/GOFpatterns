package singleton;

public class SingletonApp {
    public static void main(String[] args) throws InterruptedException{

        final int SIZE = 1000;
        Thread[] threads = new Thread[SIZE];


        for (int i = 0; i < SIZE; i++) {
            threads[i] = new Thread(new R());
            threads[i].start();
        }

        for (int i = 0; i < SIZE; i++) {
            threads[i].join();
        }

        System.out.println(Singleton.counter);

    }
}

class R implements Runnable{
    @Override
    public void run() {
        Singleton.getInstance();
    }
}
class Singleton{
    public static int counter = 0;
    private static volatile Singleton instance = null;

    private Singleton() { counter++ ;}

    public static  Singleton getInstance(){
       if (instance == null){
           synchronized (Singleton.class){
               if (instance == null){
                   instance = new Singleton();
               }
           }
       }
       return instance;
    }

    // спосіб без многопоточності
//    private static Singleton instance;
//    public static Singleton getInstance(){
//        if (instance == null){
//            instance = new Singleton();
//        }
//        return instance;
//    }

    //перший з многопот.

    //private static Singleton instance = new Singleton();
    //
    //    private Singleton() { counter++ ;}
    //
    //    public static Singleton getInstance(){
    //       return instance;
    //    }

    //другий
    //    public static synchronized Singleton getInstance(){
    //       if (instance == null){
    //           instance = new Singleton();
    //       }
    //       return instance;
    //    }
}
