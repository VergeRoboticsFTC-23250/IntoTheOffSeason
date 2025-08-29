package org.firstinspires.ftc.teamcode.opmodes.testing;

import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.PathBuilder;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.seattlesolvers.solverslib.command.CommandScheduler;
import com.seattlesolvers.solverslib.pedroCommand.FollowPathCommand;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.Robot;

@Autonomous
public class SplineTesting extends OpMode {

    public Robot robot;
    public static PathBuilder builder = new PathBuilder();

    public static PathChain line1 = builder
            .addPath(
                    new BezierLine(
                            new Point(7.940, 37.895, Point.CARTESIAN),
                            new Point(39.158, 69.835, Point.CARTESIAN)
                    )
            )
            .setConstantHeadingInterpolation(Math.toRadians(0))
            .build();

    @Override
    public void init() {
        Globals.init(Globals.MatchState.AUTONOMOUS, this);
        robot = new Robot(this, new Pose(8, 38, 0));
        robot.drivetrain.follower.setPose(new Pose(8, 38, 0));


        CommandScheduler.getInstance().registerSubsystem(robot.drivetrain);


    }

    @Override
    public void start() {
        CommandScheduler.getInstance().schedule(
                new FollowPathCommand(
                        robot.drivetrain.follower,
                        line1, true
                )
        );
    }

    /**
     * User-defined loop method
     * <p>
     * This method will be called repeatedly during the period between when
     * the play button is pressed and when the OpMode is stopped.
     */
    @Override
    public void loop() {
        robot.update();
    }
}
