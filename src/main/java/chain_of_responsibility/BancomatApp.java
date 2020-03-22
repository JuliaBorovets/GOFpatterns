package chain_of_responsibility;

public class BancomatApp {
    public static void main(String[] args) {
        NoteModule note1000 = new NoteModule1000();
        NoteModule note500 = new NoteModule500();
        NoteModule note200 = new NoteModule200();
        NoteModule note100 = new NoteModule100();

//        note1000.setNextModuleMoney(note500);
//        note500.setNextModuleMoney(note200);
//        note200.setNextModuleMoney(note100);

        note1000.setNextModuleMoney(note500);
        note500.setNextModuleMoney(note100);


        note1000.takeMoney(new Money(2400));

    }
}

class Note{
    public static final int R100 = 100;
    public static final int R200 = 200;
    public static final int R500 = 500;
    public static final int R1000 = 1000;
}

class Money{
    private int atm;

    public Money(int atm) {
        this.atm = atm;
    }

    public int getAtm() {
        return atm;
    }

    public void setAtm(int atm) {
        if (atm>0 && atm<=200_00 && atm%Note.R100==0){
            this.atm = atm;
        } else {
            throw new RuntimeException("Сумма денег должна быть не более 200000 и кратная 100");
        }
    }
}

abstract class NoteModule{
    protected NoteModule next;

    abstract void takeMoney(Money money);

    void setNextModuleMoney(NoteModule module) {
        next = module;
    }
}

class NoteModule1000 extends NoteModule{
    @Override
    void takeMoney(Money money) {
        int countNote = money.getAtm()/Note.R1000;
        int remind = money.getAtm()%Note.R1000;

        if (countNote>0){
            System.out.println("Выдано " + countNote + " купюр " + Note.R1000);
        }

        if (remind>0 && next!=null){
            next.takeMoney(new Money(remind));
        }
    }
}

class NoteModule500 extends NoteModule{
    @Override
    void takeMoney(Money money) {
        int countNote = money.getAtm()/Note.R500;
        int remind = money.getAtm()%Note.R500;

        if (countNote>0){
            System.out.println("Выдано " + countNote + " купюр " + Note.R500);
        }

        if (remind>0 && next!=null){
            next.takeMoney(new Money(remind));
        }
    }
}

class NoteModule200 extends NoteModule{
    @Override
    void takeMoney(Money money) {
        int countNote = money.getAtm()/Note.R200;
        int remind = money.getAtm()%Note.R200;

        if (countNote>0){
            System.out.println("Выдано " + countNote + " купюр " + Note.R200);
        }

        if (remind>0 && next!=null){
            next.takeMoney(new Money(remind));
        }
    }
}

class NoteModule100 extends NoteModule{
    @Override
    void takeMoney(Money money) {
        int countNote = money.getAtm()/Note.R100;
        int remind = money.getAtm()%Note.R100;

        if (countNote>0){
            System.out.println("Выдано " + countNote + " купюр " + Note.R100);
        }

        if (remind>0 && next!=null){
            next.takeMoney(new Money(remind));
        }
    }
}


