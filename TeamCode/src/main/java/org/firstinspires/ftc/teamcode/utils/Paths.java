package org.firstinspires.ftc.teamcode.utils;

import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.Path;
import com.pedropathing.pathgen.Point;

public class Paths {
    public static Pose startPose = new Pose(7.700, 65.000, Math.toRadians(0));
    public static Pose preloadPose = new Pose(39.500, 64.900, Math.toRadians(0.000));
    public static Pose aroundSubPose = new Pose(65.700, 31.300, Math.toRadians(0.000));
    public static Pose push1Pose = new Pose(12.500, 23.900, Math.toRadians(0.000));
    public static Pose back1Pose = new Pose(65.700, 13.800, Math.toRadians(0.000));
    public static Pose push2Pose = new Pose(15.900, 13.600, Math.toRadians(0.000));
    public static Pose back2Pose = new Pose(64.900, 7.900, Math.toRadians(0.000));
    public static Pose push3Pose = new Pose(9.600, 8.800, Math.toRadians(0.000));
    public static Pose score1Pose = new Pose(39.500, 67.500, Math.toRadians(0.000));
    public static Pose intake2Pose = new Pose(8.400, 30.700, Math.toRadians(0.000));
    public static Pose score2Pose = new Pose(39.500, 70.400, Math.toRadians(0.000));
    public static Pose intake3Pose = new Pose(8.400, 30.600, Math.toRadians(0.000));
    public static Pose score3Pose = new Pose(39.300, 73.800, Math.toRadians(0.000));
    public static Pose intake4Pose = new Pose(8.200, 30.200, Math.toRadians(0.000));
    public static Pose score4Pose = new Pose(39.100, 77.200, Math.toRadians(0.000));
    public static Pose parkPose = new Pose(9.100, 18.800, Math.toRadians(0.000));

    public static Path[] fiveSpec;

    public static void init() {
        // Paths
        Path preload = new Path(
                new BezierLine(
                        startPose,
                        preloadPose
                )
        );
        Path aroundSub = new Path(
                new BezierCurve(
                        new Point(preloadPose.getX(), preloadPose.getY(), Point.CARTESIAN),
                        new Point(33.600, 51.100, Point.CARTESIAN),
                        new Point(27.900, 34.800, Point.CARTESIAN),
                        new Point(aroundSubPose.getX(), aroundSubPose.getY(), Point.CARTESIAN)
                )
        );
        Path push1 = new Path(
                new BezierCurve(
                        new Point(aroundSubPose.getX(), aroundSubPose.getY(), Point.CARTESIAN),
                        new Point(66.300, 23.600, Point.CARTESIAN),
                        new Point(push1Pose.getX(), push1Pose.getY(), Point.CARTESIAN)
                )
        );
        Path back1 = new Path(
                new BezierCurve(
                        new Point(push1Pose.getX(), push1Pose.getY(), Point.CARTESIAN),
                        new Point(69.700, 32.500, Point.CARTESIAN),
                        new Point(back1Pose.getX(), back1Pose.getY(), Point.CARTESIAN)
                )
        );
        Path push2 = new Path(
                new BezierLine(
                        back1Pose,
                        push2Pose
                )
        );
        Path back2 = new Path(
                new BezierCurve(
                        new Point(push2Pose.getX(), push2Pose.getY(), Point.CARTESIAN),
                        new Point(69.000, 13.600, Point.CARTESIAN),
                        new Point(back2Pose.getX(), back2Pose.getY(), Point.CARTESIAN)
                )
        );
        Path push3 = new Path(
                new BezierLine(
                        back2Pose,
                        push3Pose
                )
        );
        Path score1 = new Path(
                new BezierLine(
                        push3Pose,
                        score1Pose
                )
        );
        Path intake2 = new Path(
                new BezierCurve(
                        new Point(score1Pose.getX(), score1Pose.getY(), Point.CARTESIAN),
                        new Point(34.300, 35.200, Point.CARTESIAN),
                        new Point(intake2Pose.getX(), intake2Pose.getY(), Point.CARTESIAN)
                )
        );
        Path score2 = new Path(
                new BezierLine(
                        intake2Pose,
                        score2Pose
                )
        );
        Path intake3 = new Path(
                new BezierCurve(
                        new Point(score2Pose.getX(), score2Pose.getY(), Point.CARTESIAN),
                        new Point(34.500, 35.200, Point.CARTESIAN),
                        new Point(intake3Pose.getX(), intake3Pose.getY(), Point.CARTESIAN)
                )
        );
        Path score3 = new Path(
                new BezierLine(
                        intake3Pose,
                        score3Pose
                )
        );
        Path intake4 = new Path(
                new BezierCurve(
                        new Point(score3Pose.getX(), score3Pose.getY(), Point.CARTESIAN),
                        new Point(35.200, 34.500, Point.CARTESIAN),
                        new Point(intake4Pose.getX(), intake4Pose.getY(), Point.CARTESIAN)
                )
        );
        Path score4 = new Path(
                new BezierLine(
                        intake4Pose,
                        score4Pose
                )
        );
        Path park = new Path(
                new BezierLine(
                        score4Pose,
                        parkPose
                )
        );

        preload.setConstantHeadingInterpolation(preloadPose.getHeading());

        aroundSub.setConstantHeadingInterpolation(aroundSubPose.getHeading());

        push1.setConstantHeadingInterpolation(push1Pose.getHeading());

        back1.setConstantHeadingInterpolation(back1Pose.getHeading());

        push2.setConstantHeadingInterpolation(push2Pose.getHeading());

        back2.setConstantHeadingInterpolation(back2Pose.getHeading());

        push3.setConstantHeadingInterpolation(push3Pose.getHeading());

        score1.setConstantHeadingInterpolation(score1Pose.getHeading());

        intake2.setConstantHeadingInterpolation(intake2Pose.getHeading());

        score2.setConstantHeadingInterpolation(score2Pose.getHeading());

        intake3.setConstantHeadingInterpolation(intake3Pose.getHeading());

        score3.setConstantHeadingInterpolation(score3Pose.getHeading());

        intake4.setConstantHeadingInterpolation(intake4Pose.getHeading());

        score4.setConstantHeadingInterpolation(score4Pose.getHeading());

        park.setConstantHeadingInterpolation(parkPose.getHeading());

        fiveSpec = new Path[] {
                preload,
                aroundSub,
                push1,
                back1,
                push2,
                back2,
                push3,
                score1,
                intake2,
                score2,
                intake3,
                score3,
                intake4,
                score4,
                park
        };
    }
}
