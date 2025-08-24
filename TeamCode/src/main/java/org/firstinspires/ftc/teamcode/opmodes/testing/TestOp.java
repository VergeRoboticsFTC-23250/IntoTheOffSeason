package org.firstinspires.ftc.teamcode.opmodes.testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.hardware.SimpleServo;

@Config
@TeleOp(name = "Test Op")
public class TestOp extends OpMode {
    SimpleServo testRight, testLeft, testOther;

    public static String name = "a";

    public static double rightPos = 0.0;
    public static double leftPos = 0.0;
    public static double otherPos = 0.0;

    public static boolean leftReverse = false;

    @Override
    public void init() {
        testRight = new SimpleServo(hardwareMap, name, 0, 180);
        testLeft = new SimpleServo(hardwareMap, "b", 0, 180);
        testOther = new SimpleServo(hardwareMap, "c", 0, 180);

        if (leftReverse) {
            testLeft.setInverted(true);
        }
    }

    @Override
    public void loop() {
        testRight.setPosition(rightPos);
        testLeft.setPosition(leftPos);
        testOther.setPosition(otherPos);

        telemetry.addData("Right Position", rightPos);
        telemetry.addData("Left Position", leftPos);
        telemetry.addData("Other Position", otherPos);
    }
}
