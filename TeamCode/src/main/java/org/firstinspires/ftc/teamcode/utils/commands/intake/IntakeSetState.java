package org.firstinspires.ftc.teamcode.utils.commands.intake;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakeClaw;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakePivot;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakeTurret;

public class IntakeSetState extends CommandBase {
    private IntakeClaw intakeClaw;
    private IntakePivot intakePivot;
    private IntakeTurret intakeArm;
    private Globals.RobotState state;

    public IntakeSetState(IntakeClaw intakeClaw, IntakePivot intakePivot, IntakeTurret intakeArm, Globals.RobotState state) {
        this.intakeClaw = intakeClaw;
        this.intakePivot = intakePivot;
        this.intakeArm = intakeArm;
        this.state = state;
    }

    @Override
    public void initialize() {
        switch (state) {

        }
    }
}
