package org.firstinspires.ftc.teamcode.utils.commands;

import com.seattlesolvers.solverslib.command.ParallelCommandGroup;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.Robot;
import org.firstinspires.ftc.teamcode.utils.commands.intake.IntakeSetState;
import org.firstinspires.ftc.teamcode.utils.commands.intake.IntakeSlidesSetState;
import org.firstinspires.ftc.teamcode.utils.commands.outtake.OuttakeSetState;
import org.firstinspires.ftc.teamcode.utils.commands.outtake.OuttakeSlidesSetState;

public class SetState extends ParallelCommandGroup {

    public SetState(Robot robot, Globals.RobotState state) {
        super(
            new IntakeSetState(robot.intakeClaw, robot.intakePivot, robot.intakeTurret, state),
            new OuttakeSetState(robot.outtakeArm, robot.outtakeClaw, state),
            new IntakeSlidesSetState(robot.intakeSlides, state),
            new OuttakeSlidesSetState(robot.outtakeSlides, state)
        );
    }
}
