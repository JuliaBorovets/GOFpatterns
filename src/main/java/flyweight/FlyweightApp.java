package flyweight;

import java.util.*;

public class FlyweightApp {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        List<Shape> shapes = new ArrayList<>();

        shapes.add(factory.getShape("круг"));
        shapes.add(factory.getShape("круг"));
        shapes.add(factory.getShape("квадрат"));
        shapes.add(factory.getShape("точка"));
        shapes.add(factory.getShape("точка"));
        shapes.add(factory.getShape("круг"));

        Random rand = new Random();

        for (Shape shape: shapes) {
            int x = rand.nextInt();
            int y = rand.nextInt();

            shape.draw(x, y);

        }

    }
}

interface Shape{
    void draw(int x, int y);
}
 class Point implements Shape{
     @Override
     public void draw(int x, int y) {
         System.out.println("(" + x + ", " + y + ")" + ": рисуем точку");
     }
 }

class Circle implements Shape{
    int r = 5;
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + ", " + y + ")" + ": рисуем круг радиусом " + r);
    }
}

class Square implements Shape{
    int a = 7;

    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + ", " + y + ")" + ": рисуем квадрат со стороной " + a);
    }
}

class ShapeFactory{
    private static final Map<String, Shape> shapes = new HashMap<>();

    public Shape getShape(String shapeName){
        Shape shape = shapes.get(shapeName);

        if (shape == null){
            switch (shapeName){
                case "круг":
                    shape = new Circle();
                    break;
                case "квадрат":
                    shape = new Square();
                    break;
                case "точка":
                    shape = new Point();
                    break;
            }
            shapes.put(shapeName, shape);
        }

     return shape;
    }
}