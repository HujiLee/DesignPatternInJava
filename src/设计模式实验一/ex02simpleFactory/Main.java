package 设计模式实验一.ex02simpleFactory;

/**
 * Created by Administrator on 2016/12/12 0012.
 */
interface Shape {
    void draw();

    void erase();
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("draw a circle");
    }

    @Override
    public void erase() {

    }
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("draw a rectangle");
    }

    @Override
    public void erase() {

    }
}

class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("draw a triangle");
    }

    @Override
    public void erase() {

    }
}

class UnsupportedShapeException extends Exception {
    private String shapeStr;
    public UnsupportedShapeException(String shape){
        this.shapeStr = shape;
    }

    @Override
    public void printStackTrace() {
        System.err.println(String.format("%s is not supported shape type",shapeStr));
        super.printStackTrace();
    }
}

class ShapeFactory {
    public static final String CIRCLE = "CIRCLE";
    public static final String RECTANGLE = "RECTANGLE";
    public static final String TRIANGLE ="TRIANGLE";
    public static Shape createShape(String shape) throws UnsupportedShapeException {
        switch (shape) {
            case CIRCLE:
                return new Circle();
            case RECTANGLE:
                return new Rectangle();
            case TRIANGLE:
                return new Triangle();
            default:
                throw new UnsupportedShapeException(shape);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Shape shape = ShapeFactory.createShape(XmlUtil.getShape());
        } catch (UnsupportedShapeException e) {
            e.printStackTrace();
        }


/*        try {
            ShapeFactory.createShape(ShapeFactory.CIRCLE).draw();
        } catch (UnsupportedShapeException e) {
            e.printStackTrace();
        }

        try {
            ShapeFactory.createShape(ShapeFactory.RECTANGLE).draw();
        } catch (UnsupportedShapeException e) {
            e.printStackTrace();
        }

        try {
            ShapeFactory.createShape(ShapeFactory.TRIANGLE).draw();
        } catch (UnsupportedShapeException e) {
            e.printStackTrace();
        }

        try {
            ShapeFactory.createShape("三角形").draw();
        } catch (UnsupportedShapeException e) {
            e.printStackTrace();
        }*/




    }
}
