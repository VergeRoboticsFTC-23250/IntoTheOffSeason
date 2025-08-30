package org.firstinspires.ftc.teamcode.utils.commands.intake;

import com.seattlesolvers.solverslib.command.ConditionalCommand;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.Robot;
import org.firstinspires.ftc.teamcode.utils.commands.SetState;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakeClaw;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakePivot;

public class DropAndIntake extends SequentialCommandGroup {

    double orientation;
    IntakePivot intakePivot;
    IntakeClaw intakeClaw;

    public DropAndIntake(double orientation, Robot robot) {
        super(
                new InstantCommand(
                        () -> {
                            robot.intakeClaw.open();
                            if (orientation == 0) {
                                robot.intakeClaw.setWrist(IntakeClaw.wristHome);
                            } else if (orientation == 45) {
                                robot.intakeClaw.setWrist(IntakeClaw.wristPos45);
                            } else if (orientation == -45) {
                                robot.intakeClaw.setWrist(IntakeClaw.wristNeg45);
                            } else if (orientation == 90) {
                                robot.intakeClaw.setWrist(IntakeClaw.wristPos90);
                            }
                            robot.intakePivot.setPivot(IntakePivot.pivotIntake);
                        }
                ),
                new WaitCommand(500),
                new InstantCommand(robot.intakeClaw::close),
                new WaitCommand(250),
                new SetState(robot, Globals.RobotState.INTAKE_SUB),
                new WaitCommand(400),
                new ConditionalCommand(
                        new SetState(robot, Globals.RobotState.HOME),
                        new SetState(robot, Globals.RobotState.INTAKE_SUB),
                        () -> robot.intakeClaw.getColor() != IntakeClaw.Color.OTHER
                )
        );
    }
}
