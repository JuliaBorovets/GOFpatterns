package state;

public class StateApp {
    public static void main(String[] args) {
//        Station dfm = new RadioDFM();
//        Radio radio = new Radio();
//        radio.setStation(dfm);
//
//        for (int i = 0; i < 10; i++) {
//            radio.play();
//            radio.nextStation();
//        }

        Human human = new Human();
        human.setState(new Work());

        for (int i = 0; i < 10; i++) {
            human.doSomething();
        }
    }
}

class Human{
    Activity state;

    public void setState(Activity s){ this.state = s;}

    public void doSomething(){ state.doSomething(this);}
}
interface Activity{
    void doSomething(Human context);
}

class Work implements Activity{
    @Override
    public void doSomething(Human context) {
        System.out.println("Working...");
        context.setState(new WeekEnd());
    }
}
class WeekEnd implements Activity{
    private int count = 0;

    @Override
    public void doSomething(Human context) {
        if (count<3){
            System.out.println("Resting...");
            count++;
        } else {
            context.setState(new Work());
        }
    }
}









interface Station{
    void play();
}

//State
class Radio7 implements Station{
    @Override
    public void play() { System.out.println("Radio7..."); }
}

class RadioDFM implements Station{
    @Override
    public void play() { System.out.println("RadioDFM..."); }
}

class VestiFM implements Station{
    @Override
    public void play() { System.out.println("VestiFM..."); }
}

//Context

class Radio{
    Station station;

    public void setStation(Station station) { this.station = station; }

    void nextStation(){
        if (station instanceof Radio7){
            setStation(new RadioDFM());
        }else if (station instanceof RadioDFM){
            setStation(new VestiFM());
        }else if (station instanceof VestiFM){
            setStation(new Radio7());
        }
    }

    void play(){
        station.play();
    }
}


