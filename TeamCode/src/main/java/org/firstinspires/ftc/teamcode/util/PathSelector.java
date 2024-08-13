package org.firstinspires.ftc.teamcode.util;

import java.util.ArrayList;
import java.util.HashMap;

public class PathSelector {

    private static HashMap<String,Path> hashPath = PathSetter.pathList;

    private static ArrayList<String> keyMaps = new ArrayList<>(hashPath.keySet());
    private static String currentSelect;
    private static int debounce = 0;
    private static int selection = 0;
    public static void selectPath (boolean select) {
        if ((select) && (debounce == 0)) {
            if (selection == keyMaps.size()) {
                selection = 0;
            } else {
                selection += 1;
            }

            currentSelect = keyMaps.get(selection);
            debounce = 1;
        } else if (!(select) && (debounce == 1)) {
            debounce = 0;
        }
    }

    public static String broadcastSelectedPath() {
        return currentSelect;
    }

    public static Path getFinalPath() {
        return hashPath.get(currentSelect);
    }
}
