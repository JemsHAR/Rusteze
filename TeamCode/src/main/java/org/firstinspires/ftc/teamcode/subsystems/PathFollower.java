package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.teamcode.util.Util;
import org.firstinspires.ftc.teamcode.util.Vector2D;
import org.firstinspires.ftc.teamcode.util.Path;

import org.firstinspires.ftc.teamcode.util.NodePoint;


public class PathFollower {

    static int currentnode = 0;

    final static double radius = 20; // in centermetres

    public static boolean followPath(Path path, Vector2D robotpos) {
        //position has x,y and direction
        //path has array list called nodePath and
        NodePoint currentNode = path.getNode(currentnode);
        Vector2D tofirstnode = robotpos.sub(currentNode.getVector());


        MotorController.movementpid.setSetPoint(0);
        robotpos.getMag();

        if (tofirstnode.getMag() > radius) {
           MotorController.sendMotorPower(tofirstnode.getMag(), tofirstnode.getDir(), Util.convertangle(RobotIMU.getYaw()-currentNode.getOrientation()));

        } else {
            currentnode += 1;
            if (currentnode >= path.getNodes().size()) {
                return true;
            }
        }
        return false;
    }


    }




