package org.firstinspires.ftc.teamcode.utils.subsystems.intake;

import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.Command;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.command.WaitUntilCommand;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.solversHardware.SolversMotorEx;

public class IntakeSlides extends SubsystemBase {
    public SolversMotorEx motor;
    public RevTouchSensor touch;
    public Motor.Encoder encoder;
    public PIDFController controller;

    public static double p = 0.0005;
    public static double i = 0;
    public static double d = 0.000025;
    public static double f = 0;

    public static double tolerance = 5000;
    public static double ticksPerIn = 1801.96;

    public static int home = 0;
    public static int max = 36500;
    public static int transfer = 0;
    public static int half = 19000;

    public static boolean isHoming;

    public static boolean initialized = false;

    public IntakeSlides(HardwareMap hMap, final String motor, final String touch, final String encoder) {
        this.motor = new SolversMotorEx(hMap.get(DcMotorEx.class, motor), 0.01);
        this.motor.setDirection(DcMotorSimple.Direction.REVERSE);
        this.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        this.touch = hMap.get(RevTouchSensor.class, touch);
        this.encoder = new Motor(hMap, encoder).encoder;
        this.encoder.reset();

        controller = new PIDFController(p,i,d,f);
        controller.setTolerance(tolerance);

        initialized = true;
    }

    @Override
    public void periodic() {
        if(!initialized) return;
        runPID();
    }

    private void runPID(){
        if (isHoming) return;

        if (touch.isPressed() && controller.getSetPoint() == home) {
            encoder.reset();
        }

        double raw = controller.calculate(encoder.getPosition());

        double power = Math.pow(raw, 2) * Math.signum(raw);

        motor.setPower(power);
    }

    public Command runToPosition(int pos){
        return new InstantCommand(() -> controller.setSetPoint(pos)).andThen(new WaitUntilCommand(() -> controller.getPositionError() <= tolerance));
    }

    public Command home(){
        return runToPosition(home);
    }

    public Command max(){
        return runToPosition(max);
    }

    public Command transfer(){
        return runToPosition(transfer);
    }

    public Command half(){
        return runToPosition(half);
    }
}
