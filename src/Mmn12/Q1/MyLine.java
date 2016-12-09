package Mmn12.Q1;

import java.awt.*;

/**
 * Created by Ez_Dor on 01/12/2016.
 */
public class MyLine extends MyShape {

    public MyLine(Point p1, Point p2, Color color) {
        super(p1, p2, color);
    }

    public void draw(Graphics g) {
        super.paintComponent(g);
        g.setColor(get_color());
        g.drawLine((int) _p1.getX(), (int) _p1.getY(), (int) _p2.getX(), (int) _p2.getY());
    }

    public boolean equals(MyLine line) {
        return (getShapeWidth() == line.getShapeWidth() && getShapeHeight() == line.getShapeHeight());
    }
}
