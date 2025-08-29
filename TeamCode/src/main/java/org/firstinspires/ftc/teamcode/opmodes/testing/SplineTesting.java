package org.firstinspires.ftc.teamcode.opmodes.testing;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.Path;
import com.pedropathing.pathgen.PathBuilder;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.CommandScheduler;
import com.seattlesolvers.solverslib.pedroCommand.FollowPathCommand;

import org.firstinspires.ftc.teamcode.pedroPathing.constants.FConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.LConstants;
import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.Robot;

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
        CommandScheduler.getInstance().registerSubsystem(robot.drivetrain);

        //initialize path
        path = new Path(new BezierLine(new Point(0,0, Point.CARTESIAN), new Point(DISTANCE,0, Point.CARTESIAN)));
        path.setConstantHeadingInterpolation(0);

        //schedule command
        CommandScheduler.getInstance().schedule(
                new FollowPathCommand(
                        robot.drivetrain.follower,
                        path, true
                )
        );
    }
    @Override
    public void run() {
        robot.drivetrain.follower.update();
    }
}
