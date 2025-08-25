package org.firstinspires.ftc.teamcode.utils.vision;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.teamcode.utils.Globals;

public class Vision {
    public Limelight3A limelight;
    public LLResult latestResult;
    public ServoImplEx light;
    public static final double LL_HEIGHT_IN = 10; // TODO set this
    public static final double LL_ANGLE_DEG = 45; // TODO set this
    public static final double LIGHT_BRIGHTNESS = 1;

    public static final int AI_DETECT_PIPELINE = 2;

    public Vision() {
        limelight = Globals.hMap.get(Limelight3A.class, "limelight");
        light = Globals.hMap.get(ServoImplEx.class, "light");
        Globals.telemetry.setMsTransmissionInterval(11);
        limelight.pipelineSwitch(AI_DETECT_PIPELINE);
        limelight.start();
        update();
    }

    public void update() {
        if (Globals.isScanning) {
            latestResult = limelight.getLatestResult();
            light.setPosition(LIGHT_BRIGHTNESS);
        } else if (light.getPosition() != 0){
            light.setPosition(0);
        }
    }

    public boolean isTargetVisible() {
        return latestResult != null && latestResult.isValid();
    }

    public double[] getTargetPos() {
        double y = LL_HEIGHT_IN * Math.tan(Math.toRadians(LL_ANGLE_DEG + latestResult.getTy()));
        double hypot = Math.hypot(y, LL_HEIGHT_IN);
        double x = hypot * Math.tan(Math.toRadians(latestResult.getTx()));

        return new double[]{x, y};
    }
}
