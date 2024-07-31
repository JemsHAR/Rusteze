package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.util.Vector2D;
import org.firstinspires.ftc.teamcode.util.Path;

import org.firstinspires.ftc.teamcode.util.NodePoint;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class PathFollower {

    int currentnode = 0;

    final double radius = 420; // in centermetres

    public void followPath(Path path, Vector2D robotpos) {
        //position has x,y and direction
        //path has array list called nodePath and

        Vector2D tofirstnode = robotpos.sub(path.getNode(currentnode).getVector());
        MotorController.movementpid.setSetPoint(0);
        robotpos.getMag();

        if (tofirstnode.getMag() > radius) {
           double output = MotorController.movementpid.calculate(
                    tofirstnode.getMag()
            );
             //send output to motors

        } else {
            currentnode = 1;
            if (currentnode >= path.getNodes().size()) {

                //stop this
            }


        }


    }


    }




