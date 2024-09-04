package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.canvas.Rotation;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.kinematics.DifferentialOdometry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name="odometry test")
public class Odometry extends LinearOpMode {
    static final double TRACKWIDTH = 13.7;

    // convert ticks to inches
    static final double TICKS_TO_INCHES = 15.3;
    @Override
    public void runOpMode() {

        // create our encoders
        MotorEx encoderLeft, encoderRight;
        encoderLeft = new MotorEx(hardwareMap, "left_encoder");
        encoderRight = new MotorEx(hardwareMap, "right_encoder");

        // create our odometry
        DifferentialOdometry diffOdom = new DifferentialOdometry(
                () -> encoderLeft.getCurrentPosition() * TICKS_TO_INCHES,
                () -> encoderRight.getCurrentPosition() * TICKS_TO_INCHES,
                TRACKWIDTH
        );

        // update the initial position
        diffOdom.updatePose(new Pose2d(1, 2, Rotation2d.fromDegrees(90))); //From degrees gives radians
        waitForStart();
        // control loop
        while (!isStopRequested()) {
            /* implementation */

            // update the position
            diffOdom.updatePose();

            telemetry.addLine("Odom Pose" + diffOdom.getPose());
        }
    }
}
