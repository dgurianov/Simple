package gud.example.structural.bridge;


/*
                             bridge (to let extendingA and extendingB use Implementation1 or Implementation2 casted to interfaceX)
         abstract ----------------------------  interfaceX
         /    \                                  /    \
   extendingA  extendingB             implementation1 implementation2

*/

public class PaperBridgeSample {
    public static void main(String[] args) {
        //Bridge classes casted to the same Bridge interface Writer
        Writer sorryWriter = new SorryWriter();
        Writer tyWriter = new ThankYouWriter();

        //Abstraction classes that use Writer bridge interface to take any type of writer.
        ColorPaper cp = new ColorPaper(sorryWriter,"Pink!!!");
        StarPaper sp = new StarPaper(tyWriter,50);

        cp.print();
        sp.print();

    }
}

//Create tree of  implementations under one interface (Bridge interface)
interface Writer{
    public String write();
}

class SorryWriter implements Writer{

    @Override
    public String write() {
        return "Sorry";
    }
}

class ThankYouWriter implements Writer{
    @Override
    public String write() {
        return "Thank you";
    }
}
//Create another tree of classes that extends from abstract (Abstraction)
abstract class Paper{
    protected Writer writer;

    protected Paper(Writer writer) {
        this.writer = writer;
    }
    public abstract void print();
}

class ColorPaper extends Paper {
    private final String myColor;
    public ColorPaper(Writer writer, String color) {
        super(writer);
        this.myColor = color;
    }

    @Override
    public void print() {
        //Bridge (Writer interface) usage
        System.out.println("There is "+this.writer.write()+"  message written on the "+this.myColor+" paper ");
    }
}

class StarPaper extends Paper {
    private final int amountOfStars;

    public StarPaper(Writer writer, int stars) {
        super(writer);
        this.amountOfStars = stars;
    }

    @Override
    public void print() {
        //Bridge (Writer interface) usage
        System.out.println("There is " + this.writer.write() + " message written on the paper with " + this.amountOfStars + " stars ");
    }
}
