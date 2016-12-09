package Mmn12.Q1;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class TheShapesThing extends JPanel {
    private ArrayList _cloneShapes, _shapes;
    private MyRectangle _rectangle1, _rectangle2;
    private MyOval _oval1, _oval2;
    private MyLine _line1, _line2;
    private final int MAX_POINT_LOCATION = 200, NUM_OF_SHAPES = 6;

    /**********
     Constructor
     ***********/
    public TheShapesThing() throws CloneNotSupportedException {
        _shapes = new ArrayList<MyShape>();
        _cloneShapes = new ArrayList<MyShape>();
        initShapes();
        initShapeList();
        cloneShapeList();
    }


    /********
     * private methods
     ********/

    private void initShapes() {
        Point[] p1 = new Point[NUM_OF_SHAPES];
        Point[] p2 = new Point[NUM_OF_SHAPES];
        for (int i = 0; i < NUM_OF_SHAPES; i++) {
            p1[i] = getRandomP1();
            p2[i] = getRandomP2((int) p1[i].getX(), (int) p1[i].getY());
        }

        _rectangle1 = new MyRectangle(p1[1], p2[1], Color.GREEN, true);
        _rectangle2 = new MyRectangle(p1[2], p2[2], Color.GREEN, false);
        _oval1 = new MyOval(p1[3], p2[3], Color.RED, true);
        _oval2 = new MyOval(p1[4], p2[4], Color.RED, false);
        _line1 = new MyLine(p1[5], p2[5], Color.BLUE);
        _line2 = new MyLine(p1[0], p2[0], Color.BLUE);
    }

    private void initShapeList() {
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
            try {
                MyShape cloneShape = (MyShape) shape.clone();
                cloneShape._p1.move((int) shape._p1.getX() + 10, (int) shape._p1.getY() + 10);
                cloneShape._p2.move((int) shape._p2.getX() + 10, (int) shape._p2.getY() + 10);
                if (cloneShape.isFill()) {
                    cloneShape.set_color(Color.gray);
                }
                _cloneShapes.add(cloneShape);
            } catch (CloneNotSupportedException err) {
                err.printStackTrace();
            }


        }

    }


    private Point getRandomP2(int minX, int maxY) {
        Random rand = new Random();
        int rand1 = rand.nextInt(MAX_POINT_LOCATION - minX) + minX;
        int rand2 = rand.nextInt(maxY);
        Point p = new Point(rand1, rand2);
        return p;
    }

    private Point getRandomP1() {

        Random rand = new Random();
        int x = Math.min(rand.nextInt(MAX_POINT_LOCATION), 190);
        int y = Math.max(rand.nextInt(MAX_POINT_LOCATION), 10);
        Point p = new Point(x, y);
        return p;
    }

    /********
     * public methods
     ********/
    public void doTheShapesThing() {

        JFrame jFrame = new JFrame();

        jFrame.setTitle("Akuna Matata Let do the shape thingggg");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(400, 400);
        jFrame.add(this);
        jFrame.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        MyShape s;
        for (int i = 0; i < NUM_OF_SHAPES; i++) {
            s = (MyShape) _shapes.get(i);
            s.draw(g);

        }

        for (int i = 0; i < NUM_OF_SHAPES; i++) {
            s = (MyShape) _cloneShapes.get(i);
            s.draw(g);
        }

    }

}
