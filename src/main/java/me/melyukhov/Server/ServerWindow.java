package me.melyukhov.Server;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class ServerWindow extends JFrame {

    private TextField hostField;
    private static Server server;
    private MouseEvents mouseEvents;

    public ServerWindow() throws IOException {
        super();
        new Thread(()-> {
            try {
                server = new Server();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(120,70);
        hostField = new TextField(9);
        hostField.setEditable(false);
        add(hostField);
        setVisible(true);
        List<String> addresses = new LinkedList<>();
        Enumeration e = NetworkInterface.getNetworkInterfaces();
        while(e.hasMoreElements()) {
            NetworkInterface n = (NetworkInterface) e.nextElement();
            Enumeration ee = n.getInetAddresses();
            while (ee.hasMoreElements()) {
                InetAddress i = (InetAddress) ee.nextElement();
                System.out.println(i.getHostAddress());
                addresses.add(i.getHostAddress());
            }
        }
        Function<List<String>,String> fun = (l)->{
            for(String str: l){
                if(str.contains("192.168")) return str;
            }
            return null;
        };
        hostField.setText(fun.apply(addresses));
        mouseEvents = new MouseEvents();
        addMouseListener(mouseEvents);
        addMouseMotionListener(mouseEvents);
        addMouseWheelListener(mouseEvents);
    }




    public static Server getServer() {
        return server;
    }
}
