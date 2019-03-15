package me.melyukhov.Common;

import me.melyukhov.Common.MouseAction;

import java.awt.*;

public interface IHandler {
    public void handle(MouseAction mouseAction) throws AWTException;
}
