package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

// importing subsystems/util
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.subsystems.LocalisationManager;
import org.firstinspires.ftc.teamcode.util.PathSetter;
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
                hardwareMap.get(DcMotor.class, "2"), // left front is 2 REVERSE
                hardwareMap.get(DcMotor.class, "3"), // left back is 3
                hardwareMap.get(DcMotor.class, "1"), // right front is 1 REVERSE
                hardwareMap.get(DcMotor.class, "0") // right back 0
        );

        WebcamOne = new LocalisationManager(hardwareMap.get(WebcamName.class, "Webcam 1"));
        RobotIMU.initialiseIMU(hardwareMap.get(IMU.class, "IMU"), true);



        waitForStart();

        RobotIMU.resetYaw();

        while (opModeIsActive() && !(isStopRequested())) {

            Vector2D currentTagVector = WebcamOne.processAprilTags(Math.toDegrees(RobotIMU.getYaw()));


            if (currentTagVector != null) {

                telemetry.addLine(currentTagVector.toString());
                telemetry.addLine("IMU: " + Math.toDegrees(RobotIMU.getYaw()));
                telemetry.addLine(WebcamOne.getDebug());
                telemetry.addLine("Adjusted Vec" + LocalisationManager.adjustedvecnum);
                telemetry.addLine("Original April Tag Vec:" + LocalisationManager.apriltagvec);
                telemetry.addLine("the Hash map contains this" + LocalisationManager.aprilTags);




                telemetry.update();

            }
        }
    }
}
