package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.seattlesolvers.solverslib.hardware.SimpleServo;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.solversHardware.SolversMotorEx;

@Config
@TeleOp(name="TeleOp")
public class SoloTeleOp extends OpMode {

//    public static double posArm = 0.77;
//    public static double posPivot = 0.62;
//    public static double posClaw = 0.4;
//    public static boolean usePivot = false;
    public Gamepad oldGamepad1;

//    public Motor.Encoder liftEncoder, extendoEncoder;
//    public TouchSensor liftTouch, extendoTouch;
//    public DigitalChannel pin0, pin1; // for the color rangefinder
//    public Vision vision;
    public SimpleServo intakeTurret, intakePivot, intakeClaw, intakeWrist, outtakeArmLeft, outtakeArmRight, outtakePivot, outtakeClaw;
    public SolversMotorEx liftLeft, liftRight, extendo;
    public Motor.Encoder liftEncoder, extendoEncoder;
//    public Follower thingy;


    /**
     * User-defined init method
     * <p>
     * This method will be called once, when the INIT button is pressed.
     */
    @Override
    public void init() {
//        liftTouch = hardwareMap.get(TouchSensor.class, "liftTouch");
//        extendoTouch = hardwareMap.get(TouchSensor.class, "extendoTouch");

//        liftEncoder = new Motor(hardwareMap, "liftEncoder").encoder;

//        pin0 = hardwareMap.digitalChannel.get("pin0");
//        pin1 = hardwareMap.digitalChannel.get("pin1");

//        Globals.init(Globals.MatchState.TELEOP, this);
//        vision = new Vision();
//
//        Globals.isScanning = true;

//        thingy = new Follower(hardwareMap, FConstants.class, LConstants.class);

//        intakeTurret = new SimpleServo(hardwareMap, "intakeTurret", 0, 324);
//        intakePivot = new SimpleServo(hardwareMap, "intakePivot", 0, 180);
//        intakeClaw = new SimpleServo(hardwareMap, "intakeClaw", 0, 180);
//        intakeWrist = new SimpleServo(hardwareMap, "intakeWrist", 0, 180);
//
//
//        intakeTurret.setPosition(IntakeTurret.forward);

//        outtakeArmLeft = new SimpleServo(hardwareMap, "outtakeArmLeft", 0, 180);
//        outtakeArmRight = new SimpleServo(hardwareMap, "outtakeArmRight", 0, 180);
//
//        outtakePivot = new SimpleServo(hardwareMap, "outtakePivot", 0, 180);
//
//        outtakeClaw = new SimpleServo(hardwareMap, "outtakeClaw", 0, 180);

        liftLeft = new SolversMotorEx(hardwareMap.get(DcMotorEx.class, "liftLeft"), 0.01);
        liftRight = new SolversMotorEx(hardwareMap.get(DcMotorEx.class, "liftRight"), 0.01);

        liftEncoder = new Motor(hardwareMap, "liftEncoder").encoder; // might cause problems bc it's not on a motor

        extendo = new SolversMotorEx(hardwareMap.get(DcMotorEx.class, "extendo"), 0.01);
        extendoEncoder = new Motor(hardwareMap, "extendo").encoder;

        extendo.setDirection(DcMotorEx.Direction.REVERSE);

        oldGamepad1 = new Gamepad();
    }

    @Override
    public void start() {
//        thingy.startTeleopDrive();
    }

    /**
     * User-defined loop method
     * <p>
     * This method will be called repeatedly during the period between when
     * the play button is pressed and when the OpMode is stopped.
     */
    @Override
    public void loop() {

//        vision.update();
//
//        telemetry.addData("visible", vision.isTargetVisible());
//        if (vision.isTargetVisible()) {
//            double[] pos = vision.getTargetPos();
//            telemetry.addData("x", "%.2f in", pos[0]);
//            telemetry.addData("y", "%.2f in", pos[1]);

//        thingy.setTeleOpMovementVectors(
//                -gamepad1.right_stick_y,
//                -gamepad1.right_stick_x,
//                -gamepad1.left_stick_x
//        );
//
//        thingy.update();


        // use the old gamepad to detect button presses to make it rotate once just on rising edge
        // make it right and left bumper to rotate 90 to the left or right

//        if (gamepad1.right_bumper && !oldGamepad1.right_bumper) {
//            intakeTurret.rotateByAngle(-30);
//        } else if (gamepad1.left_bumper && !oldGamepad1.left_bumper) {
//            intakeTurret.rotateByAngle(30);
//        }
//
//        oldGamepad1.copy(gamepad1);



//        liftLeft.setPower(power);
//        liftRight.setPower(power);

//        telemetry.addData("liftPower", power);
        telemetry.addData("liftPos", liftEncoder.getPosition());

        telemetry.addData("extendoPos", extendoEncoder.getPosition());

        double power = gamepad1.right_trigger - gamepad1.left_trigger;
        extendo.setPower(power);

//        telemetry.update();
    }
}

