package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.util.Vector2D;

public class MotorController {
    private static DcMotor leftfront;
    private static DcMotor leftback;
    private static DcMotor rightfront;
    private static DcMotor rightback;


    public static PIDController movementpid = new PIDController(0.2,0.02,0.03);
    public static PIDController rotatepid = new PIDController(0.002,0.003,0.004);



    public static void initialiseMotors(DcMotor leftFront, DcMotor leftBack, DcMotor rightFront, DcMotor rightBack) {
        leftfront = leftFront;
        leftback = leftBack;
        rightfront = rightFront;
        rightback = rightBack;
    }

    public static void sendMotorPower(double distance, double direction, double rotation){
        Vector2D vector = new Vector2D(1, direction,false);

        double max;
        double lateral = vector.getY();
        double axial = vector.getX();
        double varmovementpid = movementpid.calculate(distance);
        double rotationpid = rotatepid.calculate(rotation);

        double LeftFrontPower  = (axial*varmovementpid) + (lateral*varmovementpid) + (1*rotationpid);
        double RightFrontPower = (axial*varmovementpid) - (lateral*varmovementpid) - (1*rotationpid);
        double LeftBackPower   = (axial*varmovementpid) - (lateral*varmovementpid) + (1*rotationpid);
        double RightBackPower  = (axial*varmovementpid) + (lateral*varmovementpid) - (1*rotationpid);

        max = Math.max(Math.abs(LeftFrontPower), Math.abs(RightFrontPower));
        max = Math.max(max, Math.abs(LeftBackPower));
        max = Math.max(max, Math.abs(RightBackPower));

        if (max > 1.0) {
            max -= 0.1;
            LeftFrontPower  /= max;
            RightFrontPower /= max;
            LeftBackPower   /= max;
            RightBackPower  /= max;
        }

        leftback.setPower(LeftBackPower);
        rightback.setPower(RightBackPower);
        leftfront.setPower(LeftFrontPower);
        rightfront.setPower(RightFrontPower);

    }

}
