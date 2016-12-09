package Mmn12.Q1;

import java.awt.*;


public class MyRectangle extends MyBoundedShape {

    public MyRectangle(Point p1, Point p2, Color color, boolean fill) {
        super(p1, p2, color, fill);
    }

    public void draw(Graphics g) {
        super.paintComponent(g);
        g.setColor(get_color());
        if (isFill()) {
            g.fillRect((int)_p1.getX(), (int)_p1.getY(), getShapeWidth(), getShapeHeight());
        } else {
            g.drawRect((int) _p1.getX(), (int) _p1.getY(), getShapeWidth(), getShapeHeight());
        }


    }
}
