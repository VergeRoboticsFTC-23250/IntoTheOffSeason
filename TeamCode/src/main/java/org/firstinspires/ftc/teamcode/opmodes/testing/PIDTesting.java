package org.firstinspires.ftc.teamcode.opmodes.testing;

import com.acmerobotics.dashboard.config.Config;
import com.pedropathing.localization.Pose;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.solversHardware.SolversMotorEx;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.Robot;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakePivot;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakeTurret;

@Disabled
@Config
@TeleOp(name="PID Testing")
public class PIDTesting extends CommandOpMode {

    public SolversMotorEx extendo;
    public Motor.Encoder extendoEncoder;
    public Robot robot;
    public Gamepad previous;
    public static double pos = 3;

    @Override
    public void initialize() {
        Globals.init(Globals.MatchState.TELEOP, this);

        robot = new Robot(this, new Pose(0,0,0));

        register(robot.intakeSlides, robot.intakeTurret, robot.intakePivot);

        robot.intakeSlides.extendoEncoder.reset();

        robot.intakeSlides.setPos(20000);
        robot.intakeTurret.setTurret(IntakeTurret.forward);
        robot.intakePivot.setPivot(IntakePivot.pivotPreIntake);

        previous = new Gamepad();
    }

    @Override
    public void run() {

        telemetry.addData("extendo", robot.intakeSlides.extendoEncoder.getPosition());
        telemetry.addData("power", robot.intakeSlides.extendo.getPower());
        telemetry.update();

        // make this on press

        if (gamepad1.right_bumper && !previous.right_bumper) {
            robot.intakeTurret.rotate(robot.intakeTurret.calcTheta(2));
            robot.intakeSlides.setPos(robot.intakeSlides.getInverseKinPos(robot.intakeTurret.theta_deg));
        }
        if (gamepad1.cross) {
            robot.intakeSlides.setPos(20000);
            robot.intakeTurret.setTurret(IntakeTurret.forward);
            robot.intakePivot.setPivot(IntakePivot.pivotPreIntake);
        }

        telemetry.addData("setpoint", robot.intakeSlides.controller.getSetPoint());
        telemetry.addData("theta", robot.intakeTurret.theta_deg);

        robot.update();

        previous.copy(gamepad1);
    }
}


