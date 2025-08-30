package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.acmerobotics.dashboard.config.Config;
import com.pedropathing.localization.Pose;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.CommandScheduler;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.Robot;
import org.firstinspires.ftc.teamcode.utils.commands.SetState;

@Config
@TeleOp (name = "Solo TeleOp")
public class SoloTeleOp extends CommandOpMode {

    public Robot robot;
    public Gamepad old;

    @Override
    public void initialize() {
        Globals.init(Globals.MatchState.TELEOP, this);
        robot = new Robot(this, new Pose(0, 0, 0));
        CommandScheduler.getInstance().registerSubsystem(robot.drivetrain, robot.intakeSlides, robot.outtakeSlides, robot.intakeClaw, robot.intakeTurret, robot.intakePivot, robot.outtakeArm, robot.outtakeClaw);

        old = new Gamepad();

        telemetry.update();
    }

    @Override
    public void run() {
//        CommandScheduler.getInstance().run();

        robot.intakeSlides.runPID();
        robot.outtakeSlides.runPID();
        robot.drivetrain.follower.update();
        Globals.vivek.readButtons();


        if (gamepad1.square) {
            schedule(
                    new SetState(robot, Globals.RobotState.INTAKE_SPEC)
            );
        }
        if (gamepad1.triangle) {
            schedule(
                    new SetState(robot, Globals.RobotState.OUTTAKE_SPEC)
            );

        }

        telemetry.addData("pos", robot.outtakeClaw.outtakeClaw.getPosition());
        telemetry.update();
        old.copy(gamepad1);
    }
}
