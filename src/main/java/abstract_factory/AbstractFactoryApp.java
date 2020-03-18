package abstract_factory;

public class AbstractFactoryApp {
    public static void main(String[] args) {

        DeviceFactory deviceFactory = getFactoryByCountryCode("RU");
        Mouse m = deviceFactory.getMouse();
        Keyboard k  = deviceFactory.getKeyboard();
        TouchPad t = deviceFactory.getTouchPad();

        m.click();
        k.print();
        t.track(1, 2);


    }

    public static DeviceFactory getFactoryByCountryCode(String lang){
        switch (lang){
            case "RU":
                return new RuDeviceFactory();
            case "EN":
                return new EnDeviceFactory();
            default:
                throw new RuntimeException("Unsupported country Code " + lang );
        }
    }
}

interface DeviceFactory{
    Mouse getMouse();
    Keyboard getKeyboard();
    TouchPad getTouchPad();
}

interface Mouse{
    void click();
    void dbClick();
    void scroll(int direction);
}

interface Keyboard{
    void print();
    void println();
}
interface TouchPad{
    void track(int deltaX, int deltaY);
}

class RuMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Щелчек мышью");
    }

    @Override
    public void dbClick() {
        System.out.println("Двойной щелчек мышью");

    }

    @Override
    public void scroll(int direction) {
        if (direction < 0) {
            System.out.println("Скроллим вниз");
        } else if (direction > 0) {
            System.out.println("Скроллим вверх");
        } else {
            System.out.println("Не скроллим");
        }
    }
}

class RuKeyboard implements Keyboard{
        @Override
        public void print() {
            System.out.println("Печатаем строку");

        }

        @Override
        public void println() {
            System.out.println("Печатаем строку с переводом строки");

        }
}

class RuTouchPad implements TouchPad{
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Передвинулись на " + s + "пикселей");
    }
}

class EnMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Click");
    }

    @Override
    public void dbClick() {
        System.out.println("Double click");

    }

    @Override
    public void scroll(int direction) {
        if (direction < 0) {
            System.out.println("Scroll down");
        } else if (direction > 0) {
            System.out.println("Scroll up");
        } else {
            System.out.println("No scrolling");
        }
    }
}

class EnKeyboard implements Keyboard{
    @Override
    public void print() {
        System.out.println("Print");

    }

    @Override
    public void println() {
        System.out.println("Print line");

    }
}

class EnTouchPad implements TouchPad{
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Moved " + s + "pixels");
    }
}


class EnDeviceFactory implements DeviceFactory{
    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new EnTouchPad();
    }
}

class RuDeviceFactory implements DeviceFactory{
    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new RuTouchPad();
    }
}


