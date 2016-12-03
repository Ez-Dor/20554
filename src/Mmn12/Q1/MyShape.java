package Mmn12.Q1;


import java.awt.*;

public abstract class MyShape implements Cloneable{

    protected Point _p1;
    protected Point _p2;
    protected Color _color;

    public MyShape(Point p1, Point p2, Color color){
        _p1 = p1;
        _p2 = p2;
        _color = color;
    }

    public Color get_color() {
        return _color;
    }

    public Point get_p1() {
        return _p1;
    }

    public Point get_p2() {
        return _p2;
    }

    public void set_color(Color _color) {
        this._color = _color;
    }

    public void set_p1(Point _p1) {
        this._p1 = _p1;
    }

    public void set_p2(Point _p2) {
        this._p2 = _p2;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getWidth() {
        return (int) Math.abs(_p1.getX() - _p2.getX());

    }

    public boolean isFill() {
        return false;
    }

    public int getHeight() {
        return (int) Math.abs(_p1.getY() - _p2.getY());

    }



}
