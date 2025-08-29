package org.firstinspires.ftc.teamcode.opmodes.testing;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;

@Disabled
@TeleOp(name = "Color Sensor Test (Analog)")
public class ColorSensorAnalogTest extends OpMode {
    AnalogInput pin0;


    /**
     * User-defined init method
     * <p>
     * This method will be called once, when the INIT button is pressed.
     */
    @Override
    public void init() {
        pin0 = hardwareMap.analogInput.get("analog0");
    }

    /**
     * User-defined loop method
     * <p>
     * This method will be called repeatedly during the period between when
     * the play button is pressed and when the OpMode is stopped.
     */
    @Override
    public void loop() {
        double hue = pin0.getVoltage() / 3.3 * 360;

        telemetry.addData("Analog Voltage", pin0.getVoltage());
        telemetry.addData("Hue", hue);

        telemetry.update();
    }
}
