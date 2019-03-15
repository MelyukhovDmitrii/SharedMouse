package me.melyukhov.Client.Handlers;

import me.melyukhov.Common.IHandler;
import me.melyukhov.Common.MouseAction;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class OverHandler {

    private static Map<MouseAction.Action, IHandler> handleMap = new HashMap<>();

    static {
        handleMap.put(MouseAction.Action.click, new LeftClickHandler());
        handleMap.put(MouseAction.Action.wheel_press, new WheelPressHandler());
        handleMap.put(MouseAction.Action.right_press, new RightPressHandler());
        handleMap.put(MouseAction.Action.right_release, new RightReleaseHandler());
        handleMap.put(MouseAction.Action.left_press, new LeftPressHandler());
        handleMap.put(MouseAction.Action.left_release, new LeftReleaseHandler());
        handleMap.put(MouseAction.Action.move, new MoveHandler());
        handleMap.put(MouseAction.Action.rotate, new RotateHandler());
        handleMap.put(MouseAction.Action.wheel_release, new WheelReleaseHandler());
    }

    public static void handle(MouseAction mouseAction) throws AWTException {
        handleMap.get(mouseAction.getAction()).handle(mouseAction);
    }
}
