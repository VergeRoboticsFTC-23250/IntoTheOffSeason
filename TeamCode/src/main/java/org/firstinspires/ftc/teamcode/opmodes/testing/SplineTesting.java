package org.firstinspires.ftc.teamcode.opmodes.testing;

import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.Path;
import com.pedropathing.pathgen.Point;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.CommandScheduler;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.Robot;
import org.firstinspires.ftc.teamcode.utils.commands.SetState;

@Autonomous
public class SplineTesting extends CommandOpMode {
    public static double DISTANCE = 40;
    public Robot robot;
    //private Follower follower;
    private Path path;

    @Override
    public void initialize() {
        //initialize ftclib & subsystems
        Globals.init(Globals.MatchState.AUTONOMOUS, this);
        robot = new Robot(this, new Pose(0, 0, 0));
        CommandScheduler.getInstance().registerSubsystem(robot.drivetrain, robot.intakeSlides, robot.outtakeSlides, robot.intakeClaw, robot.intakeTurret, robot.intakePivot, robot.outtakeArm, robot.outtakeClaw);

        //initialize path
        path = new Path(new BezierLine(new Point(0,0, Point.CARTESIAN), new Point(DISTANCE,0, Point.CARTESIAN)));
        path.setConstantHeadingInterpolation(0);
        robot.outtakeClaw.open();

        //schedule command
        CommandScheduler.getInstance().schedule(
                new SetState(robot, Globals.RobotState.INTAKE_SUB)
        );
    }

    @Override
    public void run() {
        robot.intakeSlides.runPID();
        robot.outtakeSlides.runPID();
        robot.drivetrain.follower.update();
        Globals.vivek.readButtons();
        telemetry.addData("Pos", robot.intakeSlides.getPosTicks());
        telemetry.addData("extendo touch", robot.outtakeSlides.touch.isPressed());
        telemetry.update();
    }
}
