package org.firstinspires.ftc.teamcode.opmodes.testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.hardware.SimpleServo;

@TeleOp
@Config
public class RotateServo extends OpMode {

    public SimpleServo test;
    public Gamepad prevGamepad;
    public static double actualMax = 355;

    /**
     * User-defined init method
     * <p>
     * This method will be called once, when the INIT button is pressed.
     */
    @Override
    public void init() {
        test = new SimpleServo(hardwareMap, "outtakeArmRight", 0, actualMax);
        test.setPosition(.205);
    }

    /**
     * User-defined loop method
     * <p>
     * This method will be called repeatedly during the period between when
     * the play button is pressed and when the OpMode is stopped.
     */
    @Override
    public void loop() {
        // i want it to rotate to the right when the right bumper is pressed
        // and to the left when the left bumper is pressed
        // you have to use the previous joystick to get the rising edge
        // so rotate on rising edge
        // use the rotate method from the SimpleServo class
        // and copy the prev gamepad at the end

        if (prevGamepad == null) {
            prevGamepad = new Gamepad();
        }


        if (gamepad1.right_bumper && !prevGamepad.right_bumper) {
            test.rotateByAngle(45); // Rotate right by 10 degrees
        } else if (gamepad1.left_bumper && !prevGamepad.left_bumper) {
            test.rotateByAngle(-45); // Rotate left by 10 degrees
        }

        test.setRange(0, actualMax);

        if (gamepad1.cross) {
            test.setPosition(0.205);
        }

        // Update the previous gamepad state
        prevGamepad.copy(gamepad1);

    }
}
