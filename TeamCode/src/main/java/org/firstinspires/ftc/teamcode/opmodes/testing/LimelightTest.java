package org.firstinspires.ftc.teamcode.opmodes.testing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.vision.Vision;

@TeleOp(name = "Limelight Test")
public class LimelightTest extends OpMode {

    public Vision vision;

    /**
     * User-defined init method
     * <p>
     * This method will be called once, when the INIT button is pressed.
     */
    @Override
    public void init() {
        Globals.init(Globals.OpModeType.TELEOP, this);
        vision = new Vision();


    }

    /**
     * User-defined loop method
     * <p>
     * This method will be called repeatedly during the period between when
     * the play button is pressed and when the OpMode is stopped.
     */
    @Override
    public void loop() {
        Globals.isScanning = true;

        vision.update();
        telemetry.addData("Target Visible", vision.isTargetVisible());
        if (vision.isTargetVisible()) {
//            if (vision.getTargetCorners() != null)
//            telemetry.addData("corner 1", vision.getTargetCorners().get(0));
//            telemetry.addData("corner 2", vision.getTargetCorners().get(1));
//            telemetry.addData("corner 3", vision.getTargetCorners().get(2));
//            telemetry.addData("corner 4", vision.getTargetCorners().get(3));
        } else {
            telemetry.addData("Target X", "N/A");
            telemetry.addData("Target Y", "N/A");
        }
        telemetry.update();
    }
}
