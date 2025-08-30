package org.firstinspires.ftc.teamcode.utils.subsystems.outtake;

import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.Command;
import com.seattlesolvers.solverslib.command.FunctionalCommand;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.RunCommand;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.command.WaitCommand;
import com.seattlesolvers.solverslib.command.WaitUntilCommand;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.solversHardware.SolversMotorEx;

public class OuttakeSlides extends SubsystemBase {
    public SolversMotorEx leftMotor, rightMotor;
    public RevTouchSensor touch;
    public Motor.Encoder encoder;
    public PIDFController controller;

    public static double p = 0.0003;
    public static double i = 0;
    public static double d = 0.000010;
    public static double f = 0;

    public static double tolerance = 5000;

    public static int home = 0;
    public static int submersible = 30500;
    public static int bucket = 0;

    public static boolean isHoming;

    public static boolean initialized = false;

    public OuttakeSlides(HardwareMap hMap, final String leftMotor, final String rightMotor, final String touch, final String encoder) {
        this.leftMotor = new SolversMotorEx(hMap.get(DcMotorEx.class, leftMotor), 0.01);
//        this.leftMotor.setDirection(DcMotorEx.Direction.FORWARD);
//        this.rightMotor.setDirection(DcMotorEx.Direction.FORWARD);
        this.rightMotor = new SolversMotorEx(hMap.get(DcMotorEx.class, rightMotor), 0.01); // right has encoder
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

        leftMotor.setPower(power);
        rightMotor.setPower(power);
    }

    public Command runToPosition(int pos){
        return new InstantCommand(() -> controller.setSetPoint(pos)).andThen(new WaitUntilCommand(() -> controller.getPositionError() <= tolerance));
    }

    public Command home(){
        return runToPosition(home);
    }

    public Command submersible(){
        return runToPosition(submersible);
    }

    public Command bucket(){
        return runToPosition(bucket);
    }
}
