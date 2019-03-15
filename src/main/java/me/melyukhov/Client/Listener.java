package me.melyukhov.Client;

import me.melyukhov.Client.Handlers.OverHandler;
import me.melyukhov.Common.MouseAction;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Listener {

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    public Listener(String host, int port) throws IOException {
        socket = new Socket(host, port);
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
    }

    public void listen() throws IOException, ClassNotFoundException, AWTException {
        while (!Thread.interrupted()){
            MouseAction mouseAction = (MouseAction) in.readObject();
            mouseAction.setX(mouseAction.getX() * dimension.getWidth());
            mouseAction.setY(mouseAction.getY() * dimension.getHeight());
            OverHandler.handle(mouseAction);
            System.out.println(mouseAction.getX() + " " + mouseAction.getY());
        }
    }

}
