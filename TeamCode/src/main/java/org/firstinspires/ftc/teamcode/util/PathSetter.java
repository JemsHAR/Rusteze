package org.firstinspires.ftc.teamcode.util;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

import org.w3c.dom.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PathSetter {

    private static Scanner file;
    static int rows;
    private static ArrayList<NodePoint> pathList = new ArrayList<>();


    public static void readNodes() throws IOException {

        //connect the program with the text file for reading.
        File file = new File("C:\\Users\\shubh133365\\OneDrive - Brisbane Grammar School\\Robotics\\Code\\Off-Season\\Rusteze\\Rusteze\\TeamCode\\src\\main\\res\\PathSetterText");
        Scanner readFile = new Scanner(file);


        StringTokenizer token = null;

        //initialize the variables that you will need to instantiate the object
        double x = 0;
        double y = 0;
        double direction = 0;

        while (readFile.hasNextLine()) {
            token = new StringTokenizer(readFile.nextLine(), ",");

            //use the information from one line to initialize the variables needed to instatiate the object
            x = Double.parseDouble(token.nextToken());
            y = Double.parseDouble(token.nextToken());
            direction = Double.parseDouble(token.nextToken());

        }

        Vector2D pathvec = new Vector2D(x, y, true);

        NodePoint node = new NodePoint(pathvec, direction);
        pathList.add(node);

    }

    public static void main(String[] args) throws IOException {
        readNodes();

        for (NodePoint node : pathList) {
            System.out.println(node);
        }


    }
}