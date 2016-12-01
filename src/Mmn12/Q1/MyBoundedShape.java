package Mmn12.Q1;

import java.awt.*;

/**
 * Created by Ez_Dor on 24/11/2016.
 */
public abstract class MyBoundedShape extends MyShape {
    protected boolean _fill;

    public MyBoundedShape(Point p1, Point p2, Color color, boolean fill) {
        super(p1, p2, color);
        if (p2.getX() < p1.getX() || p2.getY() < p1.getY()) {
            throw new IllegalArgumentException("\nP1 should present the north-est point and P2 should present the south-west point for the shape." +
                    "\nPlease check your starts points!");
        }
        _fill = fill;
    }

    public int getMinX() {
        return (int) Math.min(_p1.getX(), get_p2().getX());

    }

    public int getMinY() {
        return (int) Math.min(_p1.getY(), _p2.getY());
    }


    @Override
    public void set_p1(Point p1) {
        if (_p2.getX() < p1.getX() || _p2.getY() < p1.getY()) {
            throw new IllegalArgumentException("\nP1 should present the north-est point and P2 should present the south-west point for the shape." +
                    "\nPlease check your starts points!");
        }
        super.set_p1(p1);
    }

    @Override
    public void set_p2(Point p2) {
        if (p2.getX() < _p1.getX() || p2.getY() < _p1.getY()) {
            throw new IllegalArgumentException("\nP1 should present the north-est point and P2 should present the south-west point for the shape." +
                    "\nPlease check your starts points!");
        }
        super.set_p1(p2);
    }

    public boolean isFill() {
        return _fill;
    }

    public void setFill(boolean _fill) {
        this._fill = _fill;
    }

    public boolean equals(MyBoundedShape boundedShape) {
        return this.getWidth() == boundedShape.getWidth() && this.getHeight() == boundedShape.getHeight();
    }
}
