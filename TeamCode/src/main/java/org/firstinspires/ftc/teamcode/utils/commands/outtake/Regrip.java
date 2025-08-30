package org.firstinspires.ftc.teamcode.utils.commands.outtake;

import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.Robot;
import org.firstinspires.ftc.teamcode.utils.commands.SetState;

public class Regrip extends SequentialCommandGroup {
    public Regrip(Robot robot) {
        addCommands(
                new SequentialCommandGroup(
                        new SetState(robot, Globals.RobotState.SPEC_REGRIP),
                        new WaitCommand(2000),
                        new InstantCommand(() -> robot.outtakeClaw.close()
                )
        ));
    }
}
