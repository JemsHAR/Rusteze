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

    public static double toRadians(double degree) { return (((90 - degree)%360)*Math.PI)/180; }
    public static double toDegrees(double radians) {
        // 180(radians)/pi = (90-degrees)%360
        double rawDegrees = (180*(radians))/(Math.PI);
        return (90-rawDegrees)%360;
    }

}
