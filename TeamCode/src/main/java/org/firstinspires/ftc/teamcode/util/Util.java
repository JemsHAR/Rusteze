package org.firstinspires.ftc.teamcode.util;

public class Util {

    public static double convertangle(double angle1){
     double returnval = 0;

        if (angle1 > Math.PI) {
         returnval = (2*Math.PI) - angle1;
        }else{
            returnval = angle1;
        }
        return returnval;
    }

    public static double toInches(double cm) {
        return cm/2.54;
    }

    public static double toCM(double inches) {
        return inches*2.54;
    }

}
