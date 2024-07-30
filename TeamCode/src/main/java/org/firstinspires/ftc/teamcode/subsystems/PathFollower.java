package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.teamcode.util.Vector2D;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class PathFollower {

    int currentnode = 0;


    public followPath(Path path, Vector2D robotpos) {
        //position has x,y and direction
        //path has array list called nodePath and

        Vector2D tofirstnode = robotpos.sub(path.getNode(currentnode).getVector());
        //move to this vector

        robotpos.getmag();

        if (tofirstnode.getmag > radius) {
            //move to firstnode


        }else{
            currentnode = 1;
            if (currentnode >= path.getNodes().size()) {
                //stop this
            }
            }
            
        }


    }



}
