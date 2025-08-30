package org.firstinspires.ftc.teamcode.utils.subsystems.intake;

import static org.firstinspires.ftc.teamcode.utils.Globals.isHomingIntake;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.hardware.rev.RevTouchSensor;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.solversHardware.SolversMotorEx;

@Config
public class IntakeSlides extends SubsystemBase {

    public SolversMotorEx extendo;
    public RevTouchSensor touch;
    public Motor.Encoder extendoEncoder;
    public PIDFController controller;

    public static double p = 0.0005;
    public static double i = 0;
    public static double d = 0.000025;
    public static double f = 0;

    public static double tolerance = 35;
    public static double ticksPerIn = 1801.96; // TODO

    public static double minPos = 0;
    public static double maxPos = 36500;
    public static double transfer = 0;
    public static double half = 19000;

    public IntakeSlides(SolversMotorEx extendo, RevTouchSensor touch, Motor.Encoder extendoEncoder) {
        this.extendo = extendo;
        this.touch = touch;
        this.extendoEncoder = extendoEncoder;

        controller = new PIDFController(p,i,d,f);
        controller.setTolerance(tolerance);
    }

    public void runPID() {
        if (isHomingIntake) return;

        if (touch.isPressed() && controller.getSetPoint() == minPos) {
            extendoEncoder.reset();
        }

        double power = controller.calculate(extendoEncoder.getPosition());

        extendo.setPower(power);
    }

    public void setPos(double pos) {
        controller.setSetPoint(pos);
    }

    public double ticksToInches(double ticks) {
        return ticks / ticksPerIn;
    }

    public int inchesToTicks(double inches) {
        return (int) Math.round(inches * ticksPerIn);
    }

    public double getPosInches() {
        return ticksToInches(extendo.getPosition());
    }

    public double getPosTicks() {
        return extendo.getPosition();
    }

    public int getInverseKinPos(double theta) {
        return (int) (extendo.getPosition() + Math.round(inchesToTicks(IntakeTurret.ARM_LENGTH_IN - (IntakeTurret.ARM_LENGTH_IN * Math.cos(Math.toRadians(theta))))));
    }
}
