package org.firstinspires.ftc.teamcode.opmodes.testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.hardware.SimpleServo;
import com.seattlesolvers.solverslib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.utils.subsystems.outtake.OuttakeArm;

@Config
@TeleOp(name = "Test Op")
public class TestOp extends OpMode {
    SimpleServo testRight, testLeft, testOther;
    Motor testMotor, testMotor2;

    public static String name = "outtakePivot";



    @Override
    public void init() {
        testOther = new SimpleServo(hardwareMap, name, 0, 1);
        testRight = new SimpleServo(hardwareMap, "outtakeArmLeft", 0, 1);
        testLeft = new SimpleServo(hardwareMap, "outtakeArmRight", 0, 1);
    }

    @Override
    public void loop() {
        if (gamepad1.cross) {
            testOther.setPosition(OuttakeArm.pivotRegrip);
        } else if (gamepad1.circle) {
            testOther.setPosition(OuttakeArm.pivotIntakeSpec);
        }
        if (gamepad1.right_bumper) {
            testRight.setPosition(OuttakeArm.armIntakeSpec);
            testLeft.setPosition(OuttakeArm.armIntakeSpec);
        } else if (gamepad1.left_bumper) {
            testRight.setPosition(OuttakeArm.armRegrip);
            testLeft.setPosition(OuttakeArm.armRegrip);
        }
    }
}
