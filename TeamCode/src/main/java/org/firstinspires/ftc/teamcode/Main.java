package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

// importing subsystems/util
import org.firstinspires.ftc.teamcode.util.Vector2D;
import org.firstinspires.ftc.teamcode.util.Util;
import org.firstinspires.ftc.teamcode.util.Path;
import org.firstinspires.ftc.teamcode.util.NodePoint;

import org.firstinspires.ftc.teamcode.subsystems.MotorController;
import org.firstinspires.ftc.teamcode.subsystems.PathFollower;
import org.firstinspires.ftc.teamcode.subsystems.RobotIMU;

@Autonomous(name="Basic: Omni Linear OpMode", group="Linear OpMode")
public class Main extends LinearOpMode {

    @Override
    public void runOpMode() {
        MotorController.initialiseMotors(
                hardwareMap.get(DcMotor.class, "LeftFront"),
                hardwareMap.get(DcMotor.class, "LeftBack"),
                hardwareMap.get(DcMotor.class, "RightFront"),
                hardwareMap.get(DcMotor.class, "RightBack")
        );

        waitForStart();

        while (opModeIsActive() && !(isStopRequested())) {
            if (PathFollower.followPath(..., )) {

            }
        }
    }
}
