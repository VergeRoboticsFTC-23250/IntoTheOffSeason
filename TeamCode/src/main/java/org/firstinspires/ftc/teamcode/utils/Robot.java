package org.firstinspires.ftc.teamcode.utils;

import static org.firstinspires.ftc.teamcode.utils.Globals.matchState;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.hardware.SimpleServo;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.solversHardware.SolversMotorEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.FConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.LConstants;
import org.firstinspires.ftc.teamcode.utils.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakeClaw;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakePivot;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakeSlides;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakeTurret;
import org.firstinspires.ftc.teamcode.utils.subsystems.outtake.OuttakeArm;
import org.firstinspires.ftc.teamcode.utils.subsystems.outtake.OuttakeClaw;
import org.firstinspires.ftc.teamcode.utils.subsystems.outtake.OuttakeSlides;

/**
 * This is the Robot class. This will make your command-based robot code a lot smoother
 * and easier to understand.
 */
public class Robot {
    public HardwareMap hMap;
    public Telemetry telemetry;

    public SolversMotorEx liftLeft, liftRight, extendoLeft, extendoRight;
    public SimpleServo outtakeArmLeftServo, outtakeArmRightServo, outtakePivotServo, outtakeClawServo, intakePivotServo, intakeWristServo, intakeClawServo;
    public TurretServo intakeTurretServo;
    public Motor.Encoder liftEncoder, extendoEncoder;
    public RevTouchSensor liftTouch, extendoTouch;
    public DigitalChannel pin0, pin1; // for the color rangefinder
    // TODO run the configuration opmode first

    public Drivetrain drivetrain;
    public OuttakeSlides outtakeSlides;
    public IntakeSlides intakeSlides;
    public OuttakeArm outtakeArm;
    public OuttakeClaw outtakeClaw;
    public IntakeClaw intakeClaw;
    public IntakeTurret intakeTurret;
    public IntakePivot intakePivot;

    public Robot(OpMode opmode, Pose pose) {
        hMap = opmode.hardwareMap;
        telemetry = opmode.telemetry;

        liftLeft = new SolversMotorEx(hMap.get(DcMotorEx.class, "liftLeft"), 0.01);
        liftRight = new SolversMotorEx(hMap.get(DcMotorEx.class, "liftRight"), 0.01);
        extendoLeft = new SolversMotorEx(hMap.get(DcMotorEx.class, "extendoLeft"), 0.01);
        extendoRight = new SolversMotorEx(hMap.get(DcMotorEx.class, "extendoRight"), 0.01);

        outtakeArmLeftServo = new SimpleServo(hMap, "outtakeArmLeft", 0, 180, AngleUnit.DEGREES);
        outtakeArmRightServo = new SimpleServo(hMap, "outtakeArmRight", 0, 180, AngleUnit.DEGREES);
        outtakePivotServo = new SimpleServo(hMap, "outtakePivot", 0, 180, AngleUnit.DEGREES);
        outtakeClawServo = new SimpleServo(hMap, "outtakeClaw", 0, 180, AngleUnit.DEGREES);
        intakeTurretServo = new TurretServo(hMap, "intakeTurret", 0, 180, AngleUnit.DEGREES);
        intakePivotServo = new SimpleServo(hMap, "intakePivot", 0, 180, AngleUnit.DEGREES);
        intakeWristServo = new SimpleServo(hMap, "intakeWrist", 0, 180, AngleUnit.DEGREES);
        intakeClawServo = new SimpleServo(hMap, "intakeClaw", 0, 180, AngleUnit.DEGREES);

        intakeTurretServo.setPwmRange(505, 2495);

        liftTouch = hMap.get(RevTouchSensor.class, "liftTouch");
        extendoTouch = hMap.get(RevTouchSensor.class, "extendoTouch");

        pin0 = hMap.get(DigitalChannel.class, "digital0");
        pin1 = hMap.get(DigitalChannel.class, "digital1");

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

        outtakeArmLeftServo.setInverted(true);

        drivetrain = new Drivetrain(new Follower(hMap, FConstants.class, LConstants.class), matchState);
        outtakeSlides = new OuttakeSlides(liftLeft, liftRight, liftTouch, liftEncoder);
        intakeSlides = new IntakeSlides(extendoLeft, extendoRight, extendoTouch, extendoEncoder);
        outtakeArm = new OuttakeArm(outtakeArmLeftServo, outtakeArmRightServo, outtakePivotServo);
        outtakeClaw = new OuttakeClaw(outtakeClawServo);
        intakeClaw = new IntakeClaw(intakeClawServo, intakeWristServo, pin0, pin1);
        intakeTurret = new IntakeTurret(intakeTurretServo);
        intakePivot = new IntakePivot(intakePivotServo);
    }

    // TODO run this in loop
    public void update() {
        intakeSlides.runPID();
        outtakeSlides.runPID();
        drivetrain.follower.update();
    }
}