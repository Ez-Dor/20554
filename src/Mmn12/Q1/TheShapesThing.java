package Mmn12.Q1;


import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class TheShapesThing {
    private ArrayList _cloneShapes, _shapes;
    private MyRectangle _rectangle1, _rectangle2;
    private MyOval _oval1, _oval2;
    private MyLine _line1, _line2;
    private final int MAX_POINT_LOCATION = 200, NUM_OF_SHAPES = 6;


    public TheShapesThing() {
        _shapes = new ArrayList<MyShape>();
        _cloneShapes = new ArrayList<MyShape>();
        initShapes();
    }

    private void initShapes() {
        _rectangle1 = new MyRectangle(getRandomPoint(), getRandomPoint(), Color.green, true);
        _rectangle2 = new MyRectangle(getRandomPoint(), getRandomPoint(), Color.red, false);
        _oval1 = new MyOval(getRandomPoint(), getRandomPoint(), Color.pink, true);
        _oval2 = new MyOval(getRandomPoint(), getRandomPoint(), Color.blue, false);
        _line1 = new MyLine(getRandomPoint(), getRandomPoint(), Color.yellow);
        _line2 = new MyLine(getRandomPoint(), getRandomPoint(), Color.cyan);
    }

    private void initShapeList() throws CloneNotSupportedException {
        _shapes.add(_rectangle1);
        _shapes.add(_rectangle2);
        _shapes.add(_oval1);
        _shapes.add(_oval2);
        _shapes.add(_line1);
        _shapes.add(_line2);

    }

    private void cloneShapeList() throws CloneNotSupportedException {
        for (int i = 0; i < _shapes.size(); i++) {
            MyShape shape = (MyShape) _shapes.get(i);
            MyShape cloneShape = (MyShape) shape.clone();
            cloneShape._p1.move(10, 10);
            cloneShape._p1.move(10, 10);
            cloneShape._color = Color.gray;
            _cloneShapes.add(cloneShape);

        }

    }


    private Point getRandomPoint() {

        Random rand = new Random();
        Point p = new Point(rand.nextInt(MAX_POINT_LOCATION), rand.nextInt(MAX_POINT_LOCATION));
        return p;
    }
}
