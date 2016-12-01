package Mmn12.Q1;

import java.awt.*;


public class MyOval extends MyBoundedShape {

    public MyOval(Point p1, Point p2, Color color, boolean fill) {
        super(p1, p2, color, fill);
    }

    public void draw(Graphics g) {

        if (isFill()) {
            g.fillOval((int) _p1.getX(), (int) _p2.getY(), (int) _p2.getX(), (int) _p2.getY());
        } else {
            g.drawOval((int) _p1.getX(), (int) _p1.getY(), (int) _p2.getX(), (int) _p2.getY());
        }


        g.setColor(get_color());
    }
}
