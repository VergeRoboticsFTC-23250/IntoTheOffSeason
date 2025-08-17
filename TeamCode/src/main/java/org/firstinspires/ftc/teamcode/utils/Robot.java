package org.firstinspires.ftc.teamcode.utils;

import static org.firstinspires.ftc.teamcode.utils.Globals.matchState;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.solversHardware.SolversMotorEx;
import com.seattlesolvers.solverslib.solversHardware.SolversServo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.FConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.LConstants;
import org.firstinspires.ftc.teamcode.utils.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.utils.subsystems.outtake.OuttakeSlides;

/**
 * This is the Robot class. This will make your command-based robot code a lot smoother
 * and easier to understand.
 */
public class Robot {
    public HardwareMap hMap;
    public Telemetry telemetry;

    public SolversMotorEx liftLeft, liftRight, extendoLeft, extendoRight;
    public SolversServo outtakeArmLeft, outtakeArmRight, outtakePivot, outtakeClaw, intakeTurret, intakePivot, intakeWrist, intakeClaw;
    public Motor.Encoder liftEncoder, extendoEncoder;
    public RevTouchSensor liftTouch, extendoTouch;

    public Drivetrain drivetrain;
    public OuttakeSlides outtakeSlides;

    public Robot(OpMode opmode, Pose pose) {
        hMap = opmode.hardwareMap;
        telemetry = opmode.telemetry;

        liftLeft = new SolversMotorEx(hMap.get(DcMotorEx.class, "liftLeft"), 0.01);
        liftRight = new SolversMotorEx(hMap.get(DcMotorEx.class, "liftRight"), 0.01);
        extendoLeft = new SolversMotorEx(hMap.get(DcMotorEx.class, "extendoLeft"), 0.01);
        extendoRight = new SolversMotorEx(hMap.get(DcMotorEx.class, "extendoRight"), 0.01);

        outtakeArmLeft = new SolversServo(hMap.get(Servo.class, "outtakeArmLeft"), 0.01);
        outtakeArmRight = new SolversServo(hMap.get(Servo.class, "outtakeArmRight"), 0.01);
        outtakePivot = new SolversServo(hMap.get(Servo.class, "outtakePivot"), 0.01);
        outtakeClaw = new SolversServo(hMap.get(Servo.class, "outtakeClaw"), 0.01);
        intakeTurret = new SolversServo(hMap.get(Servo.class, "intakeTurret"), 0.01);
        intakePivot = new SolversServo(hMap.get(Servo.class, "intakePivot"), 0.01);
        intakeWrist = new SolversServo(hMap.get(Servo.class, "intakeWrist"), 0.01);
        intakeClaw = new SolversServo(hMap.get(Servo.class, "intakeClaw"), 0.01);

        liftTouch = hMap.get(RevTouchSensor.class, "liftTouch");

        liftEncoder = new Motor(hMap, "liftRight").encoder;

        if (matchState.equals(Globals.MatchState.AUTONOMOUS)) {
            liftLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            liftRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            extendoLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            extendoRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }

        liftLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        liftRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extendoLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extendoRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        liftLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        liftRight.setDirection(DcMotorSimple.Direction.FORWARD);
        extendoLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        extendoRight.setDirection(DcMotorSimple.Direction.FORWARD);

        liftLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        extendoLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        extendoRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        outtakeArmLeft.setDirection(Servo.Direction.REVERSE);

        drivetrain = new Drivetrain(new Follower(hMap, FConstants.class, LConstants.class), matchState);
        outtakeSlides = new OuttakeSlides(liftLeft, liftRight, liftTouch, liftEncoder);
    }
}