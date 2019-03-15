package me.melyukhov.Client.Handlers;

import me.melyukhov.Client.ClientWindow;
import me.melyukhov.Common.IHandler;
import me.melyukhov.Common.MouseAction;

import java.awt.*;

public class RightPressHandler implements IHandler {
    @Override
    public void handle(MouseAction mouseAction) throws AWTException {
        ClientWindow.getMouseClient().rightPress(mouseAction.getX(), mouseAction.getY());
    }
}
