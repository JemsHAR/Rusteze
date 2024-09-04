package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class RobotIMU {
    private static double rawYaw;
    public static IMU robotIMU;
    private static boolean ISBLUE;

    public static void initialiseIMU(IMU imu, boolean BlueSide) { //imu = hardwareMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.UP;
        RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.FORWARD;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);
        imu.initialize(new IMU.Parameters(orientationOnRobot));
        robotIMU = imu;

        ISBLUE = BlueSide;

    }

    public static void resetYaw() {
        robotIMU.resetYaw();
    }
    public static double getYaw() {
        YawPitchRollAngles orientation = robotIMU.getRobotYawPitchRollAngles();
        return orientation.getYaw(AngleUnit.RADIANS);
    }

    public static String getDebug() {
        return "Robot Dir" + robotIMU.getRobotOrientationAsQuaternion();

    }
}
