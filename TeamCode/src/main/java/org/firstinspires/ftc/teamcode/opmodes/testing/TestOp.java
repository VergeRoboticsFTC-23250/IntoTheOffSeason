package org.firstinspires.ftc.teamcode.opmodes.testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class TestOp extends OpMode {
    Servo testRight, testLeft;

    public static double rightPos = 0;
    public static double leftPos = 0;

    public static boolean leftReverse = false;

    @Override
    public void init() {
        testRight = hardwareMap.get(Servo.class, "outtakeArmRight");
        testLeft = hardwareMap.get(Servo.class, "outtakeArmLeft");

        if (leftReverse) {
            testLeft.setDirection(Servo.Direction.REVERSE);
        }
    }

    @Override
    public void loop() {
        testRight.setPosition(rightPos);
        testLeft.setPosition(leftPos);
    }
}
