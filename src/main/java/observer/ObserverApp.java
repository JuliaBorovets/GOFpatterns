package observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObserverApp {
    public static void main(String[] args) {
        MeteoStation meteoStation = new MeteoStation();
        meteoStation.addObserver(new ConsoleObserver());
        meteoStation.addObserver(new FileObserver());

        meteoStation.setMeasurements(12, 320);
    }
}

interface Observed{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class MeteoStation implements Observed{
    int temperature;
    int pressure;
    List<Observer> observers = new ArrayList<>();

    public  void setMeasurements(int t, int p){
        temperature = t;
        pressure = p;
        notifyObservers();

    }
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observers) {
            o.handleEvent(temperature, pressure);
        }
    }
}

interface Observer{
    void handleEvent(int temperature, int pressure);
}

class ConsoleObserver implements Observer{
    @Override
    public void handleEvent(int temperature, int pressure) {
        System.out.println("Погода змінилася. Температура - " + temperature + ", тиск - " + pressure);
    }
}

class FileObserver implements Observer{

    @Override
    public void handleEvent(int temperature, int pressure) {
        File file;
        try {
            file = File.createTempFile("TempPres", "_txt");
            PrintWriter pw = new PrintWriter(file);
            pw.write("Погода змінилася. Температура - " + temperature + ", тиск - " + pressure);
            pw.println();
            pw.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}