package me.melyukhov.Client.Handlers;

import me.melyukhov.Client.ClientWindow;
import me.melyukhov.Common.IHandler;
import me.melyukhov.Common.MouseAction;

import java.awt.*;

public class MoveHandler implements IHandler {
    @Override
    public void handle(MouseAction mouseAction) throws AWTException {
        ClientWindow.getMouseClient().moveMouse(mouseAction.getX(), mouseAction.getY());
    }
}
