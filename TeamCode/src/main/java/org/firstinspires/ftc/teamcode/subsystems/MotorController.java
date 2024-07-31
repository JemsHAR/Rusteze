package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class MotorController {
    private DcMotor leftfront;
    private DcMotor leftback;
    private DcMotor rightfront;
    private DcMotor rightback;

    private static PIDController pid = new PIDController(0.2,0.02,0.03);

    private void initialiseMotors(DcMotor leftFront, DcMotor leftBack, DcMotor rightFront, DcMotor rightBack) {
        leftfront = leftFront;
        leftback = leftBack;
        rightfront = rightFront;
        rightback = rightBack;
    }

}
