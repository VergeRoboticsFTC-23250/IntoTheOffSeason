package org.firstinspires.ftc.teamcode.utils.subsystems.outtake;

import static org.firstinspires.ftc.teamcode.utils.Globals.isHomingOuttake;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.hardware.rev.RevTouchSensor;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.solversHardware.SolversMotorEx;

@Config
public class OuttakeSlides extends SubsystemBase {

    public SolversMotorEx liftLeft, liftRight;
    public RevTouchSensor touch;
    public Motor.Encoder liftEncoder;
    public PIDFController controller;

    public static double p = 0.0003;
    public static double i = 0;
    public static double d = 0.000010;
    public static double f = 0;

    public static double tolerance = 35;

    public static double minPos = 0;
    public static double specScore = 30500;
    public static double lowBucket = 0;
    public static double highBucket = 0;

    public OuttakeSlides(SolversMotorEx liftLeft, SolversMotorEx liftRight, RevTouchSensor touch, Motor.Encoder liftEncoder) {
        this.liftLeft = liftLeft;
        this.liftRight = liftRight; // right has encoder
        this.touch = touch;
        this.liftEncoder = liftEncoder;

        controller = new PIDFController(p,i,d,f);
        controller.setTolerance(tolerance);
    }

    public void runPID() {
        if (isHomingOuttake) return;

        if (touch.isPressed() && controller.getSetPoint() == minPos) {
            liftEncoder.reset();
        }

        double raw = controller.calculate(liftEncoder.getPosition());

        double power = Math.pow(raw, 2) * Math.signum(raw);

        liftLeft.setPower(power);
        liftRight.setPower(power);
    }

    public void setPos(double pos) {
        controller.setSetPoint(pos);
    }
}
