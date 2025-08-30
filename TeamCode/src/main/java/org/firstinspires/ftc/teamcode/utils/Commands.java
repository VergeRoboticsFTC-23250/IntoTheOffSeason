package org.firstinspires.ftc.teamcode.utils;

import com.seattlesolvers.solverslib.command.Command;
import com.seattlesolvers.solverslib.command.ParallelCommandGroup;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;

public class Commands {
    static Butterfly robot;
    public static Command intakeWall;
    public static Command outtakeSub;

    public static void init(Butterfly robot){
        Commands.robot = robot;

        intakeWall = new ParallelCommandGroup(
                robot.outtakeArm.intakeWall(),
                robot.outtakeClaw.open(),
                robot.outtakeSlides.home()
        );

        outtakeSub = new SequentialCommandGroup(
                robot.outtakeClaw.closeLoose(),
                robot.outtakeArm.regrip(),
                robot.outtakeSlides.submersible(),
                robot.outtakeClaw.closeFirm(),
                robot.outtakeArm.submersible()
        );
    }
}
