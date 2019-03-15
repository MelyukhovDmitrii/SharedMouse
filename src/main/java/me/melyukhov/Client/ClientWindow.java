package me.melyukhov.Client;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ClientWindow extends JFrame {

    private static MouseClient mouseClient;
    private TextField hostField;
    private Button connect;
    private String host;
    private int port = 21414;

    public ClientWindow() throws AWTException {
        super();
        mouseClient = new MouseClient(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice());
        setSize(150,100);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        hostField = new TextField(15);
        connect = new Button("connect");
        connect.setSize(50,10);
        add(hostField);
        add(connect);
        connect.addActionListener((e)->{
            host = hostField.getText();
            try {
                new Thread(()-> {
                    try {
                        new Listener(host, port).listen();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (AWTException e1) {
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }).start();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        setVisible(true);
    }

    public static MouseClient getMouseClient() {
        return mouseClient;
    }
}
