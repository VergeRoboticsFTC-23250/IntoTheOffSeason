package org.firstinspires.ftc.teamcode.opmodes.testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.hardware.SimpleServo;
import com.seattlesolvers.solverslib.hardware.motors.Motor;

@Config
@TeleOp(name = "Test Op")
public class TestOp extends OpMode {
    SimpleServo testRight, testLeft, testOther;
    Motor testMotor, testMotor2;

    public static String name = "a";

    public static double rightPos = 0.5;
    public static double leftPos = 0.5;
    public static double otherPos = 0.5;

    public static boolean leftReverse = false;
    public static boolean useAll = false;
    public static boolean useMotor = true;

    @Override
    public void init() {
        testRight = new SimpleServo(hardwareMap, name, 0, 180);
        if (useAll) {
            testLeft = new SimpleServo(hardwareMap, "b", 0, 180);
            testOther = new SimpleServo(hardwareMap, "c", 0, 180);
        }

        if (useMotor) {
            testMotor = new Motor(hardwareMap, "motor");
            testMotor2 = new Motor(hardwareMap, "motor2");
        }

        if (leftReverse && useAll) {
            testLeft.setInverted(true);
        }
    }

    @Override
    public void loop() {
        double power = gamepad1.right_trigger - gamepad1.left_trigger;

        testMotor.set(power);
        testMotor2.set(power);

        testRight.setPosition(rightPos);
        if (useAll) {
            testLeft.setPosition(leftPos);
            testOther.setPosition(otherPos);
        }

        telemetry.addData("power", power);

    }
}
