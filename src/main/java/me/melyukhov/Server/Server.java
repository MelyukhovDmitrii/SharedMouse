package me.melyukhov.Server;

import me.melyukhov.Common.MouseAction;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final static int port = 21414;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectOutputStream out;

    public Server() throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new ObjectOutputStream(clientSocket.getOutputStream());
    }

    public void sendMouseAction(MouseAction mouseAction) throws IOException {
        out.writeObject(mouseAction);
        System.out.println(mouseAction.getX() + " " + mouseAction.getY());
    }

}
