package me.melyukhov.Client.Handlers;

import me.melyukhov.Client.ClientWindow;
import me.melyukhov.Common.IHandler;
import me.melyukhov.Common.MouseAction;

import java.awt.*;

public class LeftClickHandler implements IHandler {
    @Override
    public void handle(MouseAction mouseAction) throws AWTException {
        ClientWindow.getMouseClient().mouseClicked(mouseAction.getX(), mouseAction.getY());
    }
}
