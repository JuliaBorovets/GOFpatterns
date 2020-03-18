package factory_method;

import java.util.Date;

public class FactoryMethodApp {
    public static void main(String[] args) {

//        WatchMaker maker = new DigitalWatchMaker();

        WatchMaker maker = getMakerByName("Digital");
        Watch watch = maker.createWatch();
        System.out.println(watch);
        watch.showTime();
    }

    public static WatchMaker getMakerByName(String name){
        if (name.equals("Digital")){
            return new DigitalWatchMaker();
        } else if (name.equals("Rome")){
            return new RomeWatchMaker();
        }
        throw new RuntimeException("Не підтримуваний виробник часів " + name);
    }
}

interface Watch{
    void showTime();
}

class DigitalWatch implements Watch{
    @Override
    public void showTime() {
        System.out.println(new Date());
    }

    @Override
    public String toString() {
        return "DigitalWatch";
    }
}

class RomeWatch implements Watch{
    @Override
    public void showTime() {
        System.out.println("VII-XX");
    }

    @Override
    public String toString() {
        return "RomeWatch";
    }
}

interface WatchMaker{
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker{
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker{
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}