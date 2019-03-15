package me.melyukhov.Client.Handlers;

import me.melyukhov.Client.ClientWindow;
import me.melyukhov.Common.IHandler;
import me.melyukhov.Common.MouseAction;

import java.awt.*;

public class WheelReleaseHandler implements IHandler {
    @Override
    public void handle(MouseAction mouseAction) throws AWTException {
        ClientWindow.getMouseClient().wheelReleased(mouseAction.getX(), mouseAction.getY());
    }
}
