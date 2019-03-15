package me.melyukhov.Common;

import java.io.Serializable;

public class MouseAction implements Serializable {

    private double x, y;
    private int rotate;
    private Action action;

    public MouseAction(double x, double y, Action action){
        this.x = x;
        this.y = y;
        this.action = action;
    }

    public MouseAction(int rotate){
        this.action = Action.rotate;
        this.rotate = rotate;
    }

    public MouseAction(Action action){
        this.action = action;
    }

    public enum Action{
        click,
        left_press,
        right_press,
        left_release,
        right_release,
        rotate,
        move,
        wheel_press,
        wheel_release,
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setRotate(int rotate) {
        this.rotate = rotate;
    }

    public Action getAction() {
        return action;
    }

    public int getRotate() {
        return rotate;
    }
}
