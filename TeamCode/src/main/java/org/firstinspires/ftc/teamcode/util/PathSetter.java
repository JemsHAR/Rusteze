package org.firstinspires.ftc.teamcode.util;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

import org.w3c.dom.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PathSetter {

    private static Scanner file;
    static int rows;
    private static HashMap<String, Path> pathList = new HashMap<>(); // changed to HashMap to support names
    public static void readNodes() throws IOException {

        //connect the program with the text file for reading.
        File file = new File("C:\\Users\\guanao675209\\OneDrive - Brisbane Grammar School\\Documents\\GitHub\\Rusteze\\TeamCode\\src\\main\\res\\PathSetterText");
        Scanner readFile = new Scanner(file);


        StringTokenizer token = null;

        //initialize the variables that you will need to instantiate the object
        double x = 0;
        double y = 0;
        double direction = 0;

        // this is to store the current path and path name
        Path currentPath = null;
        String pathName = null;

        while (readFile.hasNextLine()) { // while still is something left to read, read

            String nextLine = readFile.nextLine();

            if (nextLine.matches(".*[a-z].*")) { // check if the next line has any letter (name) for path
                if (currentPath != null) { // check - should this be if currentpath is null or path name is null?
                    pathList.put(pathName, currentPath);
                }
                currentPath = new Path(); // reset the path for the next cycle
                pathName = nextLine;
            } else {
                token = new StringTokenizer(nextLine, ",");

                //use the information from one line to initialize the variables needed to instatiate the object
                x = Double.parseDouble(token.nextToken());
                y = Double.parseDouble(token.nextToken());
                direction = Double.parseDouble(token.nextToken());

                Vector2D pathvec = new Vector2D(x, y, true);

                NodePoint node = new NodePoint(pathvec, direction);
                currentPath.addNode(node);
            }

        }

        pathList.put(pathName, currentPath);

    }

    public static void main(String[] args) throws IOException {
        readNodes();

        System.out.println(pathList);
//        for (Path node : pathList) {
//            System.out.println(Path);
//        }


    }
}