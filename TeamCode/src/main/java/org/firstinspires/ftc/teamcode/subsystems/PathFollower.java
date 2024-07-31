package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.controller.PIDController;

import org.firstinspires.ftc.teamcode.util.Vector2D;
import org.firstinspires.ftc.teamcode.util.Path;

import org.firstinspires.ftc.teamcode.util.NodePoint;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class PathFollower {

    int currentnode = 0;

    final double radius = 420;

    public PIDController pid = new PIDController(0.02,0.03,0.3);


    public void followPath(Path path, Vector2D robotpos) {
        //position has x,y and direction
        //path has array list called nodePath and

        Vector2D tofirstnode = robotpos.sub(path.getNode(currentnode).getVector());
        //move to this vector

        robotpos.getMag();

        if (tofirstnode.getMag() > radius) {
            //move to firstnode


        }else{
            currentnode = 1;
            if (currentnode >= path.getNodes().size()) {
                //stop this
            }
            }
            
        }


    }




