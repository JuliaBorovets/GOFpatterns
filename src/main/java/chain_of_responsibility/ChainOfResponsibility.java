package chain_of_responsibility;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Logger loger0 = new SMSLogger(Level.ERROR);
        Logger loger1 = new FileLogger(Level.DEBUG);
        Logger loger2 = new EmailLogger(Level.INFO);
        loger0.setNext(loger1);
        loger1.setNext(loger2);

        loger0.writeMessage("Всее хорошо", Level.INFO);
        loger0.writeMessage("Режим отладки", Level.DEBUG);
        loger0.writeMessage("Система упала", Level.ERROR);


    }
}

class Level{
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

abstract class Logger{
    int priority;
    Logger next;

    public Logger(int priority) { this.priority = priority; }

    public void setNext(Logger next) { this.next = next; }

    public void writeMessage(String message, int level) {
        if (level <= priority){
            write(message);
        }
        if (next!=null){
            next.writeMessage(message, level);
        }
    }
    abstract void write(String message);
}

class SMSLogger extends Logger{

    public SMSLogger(int priority) { super(priority); }

    public void write(String message){ System.out.println("SMS: " + message); }
}

class FileLogger extends Logger{

    public FileLogger(int priority) { super(priority); }

    public void write(String message){ System.out.println("File: " + message); }
}

class EmailLogger extends Logger{

    public EmailLogger(int priority) { super(priority); }

    public void write(String message){ System.out.println("Email: " + message); }
}