package composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args) {
        Shape square1 = new Square();
        Shape square2 = new Square();
        Shape square3 = new Square();

        Shape triangle = new Triangle();
        Shape circle1 = new Circle();
        Shape circle2 = new Circle();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.components.add(square1);
        composite2.components.add(square2);
        composite2.components.add(square3);

        composite1.components.add(triangle);
        composite1.components.add(circle1);
        composite2.components.add(circle2);

        composite.components.add(composite1);
        composite.components.add(composite2);

        composite.draw();


    }
}

interface Shape{
    void draw();
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Привет, я квадрат");
    }
}

class Triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Привет, я треугольник");
    }
}

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Привет, я круг");
    }
}

class Composite implements Shape{
    List<Shape> components = new ArrayList<>();

    @Override
    public void draw() {
        for (Shape s: components) {
            s.draw();
        }
    }
}