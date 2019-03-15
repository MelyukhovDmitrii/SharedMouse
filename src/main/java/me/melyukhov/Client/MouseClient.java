package me.melyukhov.Client;

import java.awt.*;
import java.awt.event.InputEvent;

public class MouseClient {

    private GraphicsDevice graphicsDevice;
    private GraphicsConfiguration graphicsConfiguration;
    private Robot robot;
    private double x, y;

    public MouseClient(GraphicsDevice graphicsDevice) throws AWTException {
        this.graphicsDevice = graphicsDevice;
        //graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        graphicsConfiguration = graphicsDevice.getDefaultConfiguration();
        robot = new Robot(graphicsDevice);
    }

    public void moveMouse(double x, double y) throws AWTException {
        Point pre = MouseInfo.getPointerInfo().getLocation();
        this.x = x;
        this.y = y;
        Point s = new Point((int) this.x,(int) this.y);
        robot.mouseMove(s.x,s.y);
    }

    private void mousePresed(double x, double y, int key) throws AWTException {
        moveMouse(x,y);
        robot.mousePress(key);
    }

    private void mouseReleased(double x, double y, int key) throws AWTException {
        moveMouse(x,y);
        robot.mouseRelease(key);
    }

    public void mouseClicked(double x, double y) throws AWTException {
        leftPress(x, y);
        leftReleased(x, y);
    }

    public void leftPress(double x, double y) throws AWTException {
        mousePresed(x, y, InputEvent.BUTTON1_MASK);
    }

    public void rightPress(double x, double y) throws AWTException {
        mousePresed(x,y,InputEvent.BUTTON3_MASK);
    }

    public void leftReleased(double x, double y) throws AWTException {
        mouseReleased(x,y,InputEvent.BUTTON1_MASK);
    }

    public void rightReleased(double x, double y) throws AWTException {
        mouseReleased(x,y,InputEvent.BUTTON3_MASK);
    }

    public void wheelPress(double x, double y) throws AWTException {
        mousePresed(x, y, InputEvent.BUTTON2_MASK);
    }

    public void wheelReleased(double x, double y) throws AWTException {
        mouseReleased(x, y, InputEvent.BUTTON2_MASK);
    }

    public void mouseWheel(int y){
        robot.mouseWheel(y);
    }

}
