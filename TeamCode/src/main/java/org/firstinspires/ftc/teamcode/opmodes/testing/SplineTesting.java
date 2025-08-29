package org.firstinspires.ftc.teamcode.opmodes.testing;

import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.PathBuilder;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.CommandScheduler;
import com.seattlesolvers.solverslib.pedroCommand.FollowPathCommand;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.Robot;

@Autonomous
public class SplineTesting extends CommandOpMode {

    public Robot robot;
    public static PathBuilder builder = new PathBuilder();

    public static PathChain line1 = builder
            .addPath(
                    new BezierLine(
                            new Point(0, 0, Point.CARTESIAN),
                            new Point(10, 0, Point.CARTESIAN)
                    )
            )
            .setConstantHeadingInterpolation(Math.toRadians(0))
            .build();

    @Override
    public void initialize() {
        Globals.init(Globals.MatchState.AUTONOMOUS, this);
        robot = new Robot(this, new Pose(0, 0, 0));
        robot.drivetrain.follower.setPose(new Pose(0, 0, 0));


        CommandScheduler.getInstance().registerSubsystem(robot.drivetrain);

        CommandScheduler.getInstance().schedule(
                new FollowPathCommand(
                        robot.drivetrain.follower,
                        line1, true
                )
        );
    }

    @Override
    public void run() {
        CommandScheduler.getInstance().run();
        robot.update();
    }


    /**
     * User-defined loop method
     * <p>
     * This method will be called repeatedly during the period between when
     * the play button is pressed and when the OpMode is stopped.
     */

}
