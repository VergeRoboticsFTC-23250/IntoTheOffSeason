package org.firstinspires.ftc.teamcode.utils.subsystems.intake;

import static org.firstinspires.ftc.teamcode.utils.Globals.isHomingIntake;
import static org.firstinspires.ftc.teamcode.utils.Globals.isHomingOuttake;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.hardware.rev.RevTouchSensor;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.solversHardware.SolversMotorEx;

@Config
public class IntakeSlides extends SubsystemBase {

    public SolversMotorEx extendoLeft, extendoRight;
    public RevTouchSensor touch;
    public Motor.Encoder extendoEncoder;
    public PIDFController controller;

    public static double p = 0;
    public static double i = 0;
    public static double d = 0;
    public static double f = 0;

    public static double tolerance = 35;
    public static double inPerTick = 0; // TODO

    public static double minPos = 0;

    public IntakeSlides(SolversMotorEx extendoLeft, SolversMotorEx extendoRight, RevTouchSensor touch, Motor.Encoder extendoEncoder) {
        this.extendoLeft = extendoLeft;
        this.extendoRight = extendoRight; // right has encoder
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

        double power = controller.calculate(extendoRight.getPosition());

        extendoLeft.setPower(power);
        extendoRight.setPower(power);
    }

    public void setPos(double pos) {
        controller.setSetPoint(pos);
    }

    public double ticksToInches(double ticks) {
        return ticks * inPerTick;
    }

    public double inchesToTicks(double inches) {
        return inches / inPerTick;
    }

    public double getPosInches() {
        return ticksToInches(extendoRight.getPosition());
    }
}
