package org.firstinspires.ftc.teamcode.opmodes.testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;

@Config
@TeleOp
public class MotorTest extends OpMode {

    public DcMotorImplEx motor;

    /**
     * User-defined init method
     * <p>
     * This method will be called once, when the INIT button is pressed.
     */
    @Override
    public void init() {
        motor = hardwareMap.get(DcMotorImplEx.class, "motor");
    }

    /**
     * User-defined loop method
     * <p>
     * This method will be called repeatedly during the period between when
     * the play button is pressed and when the OpMode is stopped.
     */
    @Override
    public void loop() {
        double power = gamepad1.right_trigger - gamepad1.left_trigger;

        telemetry.addData("trigger", power);
        telemetry.addData("motor power", motor.getPower());

        motor.setPower(power);

        telemetry.update();
    }
}
