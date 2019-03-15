package me.melyukhov.Server;

import me.melyukhov.Common.MouseAction;

import java.applet.Applet;
import java.awt.event.*;
import java.io.IOException;
import java.util.function.Consumer;

public class MouseEvents extends Applet implements MouseListener, MouseMotionListener, MouseWheelListener {

    public void action(MouseEvent mouseEvent, MouseAction.Action action) {
        try {
            ServerWindow.getServer().sendMouseAction(new MouseAction(mouseEvent.getX(), mouseEvent.getY(), action));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(){
        addMouseListener(this);
        addMouseMotionListener(this);
        addMouseWheelListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        switch (mouseEvent.getButton()){
            case MouseEvent.BUTTON1: action(mouseEvent, MouseAction.Action.click);
            default: break;
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        switch (mouseEvent.getButton()){
            case MouseEvent.BUTTON1: action(mouseEvent, MouseAction.Action.left_press); break;
            case MouseEvent.BUTTON2: action(mouseEvent, MouseAction.Action.wheel_press); break;
            case MouseEvent.BUTTON3: action(mouseEvent, MouseAction.Action.right_press); break;
            default: break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        switch (mouseEvent.getButton()){
            case MouseEvent.BUTTON1: action(mouseEvent, MouseAction.Action.left_release);
            case MouseEvent.BUTTON2: action(mouseEvent, MouseAction.Action.wheel_release);
            case MouseEvent.BUTTON3: action(mouseEvent, MouseAction.Action.right_release);
            default: break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        //action(mouseEvent, MouseAction.Action.move);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        action(mouseEvent, MouseAction.Action.move);
        System.out.println(mouseEvent.getX() + " " + mouseEvent.getY());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
        try {
            ServerWindow.getServer().sendMouseAction(new MouseAction(mouseWheelEvent.getWheelRotation()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
