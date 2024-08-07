package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

// importing subsystems/util
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.subsystems.LocalisationManager;
import org.firstinspires.ftc.teamcode.util.Vector2D;
import org.firstinspires.ftc.teamcode.util.Util;
import org.firstinspires.ftc.teamcode.util.Path;
import org.firstinspires.ftc.teamcode.util.NodePoint;

import org.firstinspires.ftc.teamcode.subsystems.MotorController;
import org.firstinspires.ftc.teamcode.subsystems.PathFollower;
import org.firstinspires.ftc.teamcode.subsystems.RobotIMU;

@Autonomous(name="Localisation Manager Test", group="Linear OpMode")
public class Main extends LinearOpMode {

    private static LocalisationManager WebcamOne;


    @Override
    public void runOpMode() {
        MotorController.initialiseMotors(
                hardwareMap.get(DcMotor.class, "LeftFront"),
                hardwareMap.get(DcMotor.class, "LeftBack"),
                hardwareMap.get(DcMotor.class, "RightFront"),
                hardwareMap.get(DcMotor.class, "RightBack")
        );

        WebcamOne = new LocalisationManager(hardwareMap.get(WebcamName.class, "s"));
        RobotIMU.initialiseIMU(hardwareMap.get(IMU.class, "Imu"), true);


        waitForStart();

        RobotIMU.resetYaw();

        while (opModeIsActive() && !(isStopRequested())) {


            if (WebcamOne.processAprilTags(RobotIMU.getYaw()) != null) {
                Vector2D currentTagVector = WebcamOne.processAprilTags(RobotIMU.getYaw());
                telemetry.addLine(currentTagVector.toString());
                telemetry.update();
//            if (PathFollower.followPath(..., )) {
//
//            }
            }
        }
    }
}
