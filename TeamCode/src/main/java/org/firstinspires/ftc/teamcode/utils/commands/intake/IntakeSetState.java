package org.firstinspires.ftc.teamcode.utils.commands.intake;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakeClaw;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakePivot;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakeTurret;

public class IntakeSetState extends CommandBase {
    private IntakeClaw intakeClaw;
    private IntakePivot intakePivot;
    private IntakeTurret intakeTurret;
    private Globals.RobotState state;

    public IntakeSetState(IntakeClaw intakeClaw, IntakePivot intakePivot, IntakeTurret intakeArm, Globals.RobotState state) {
        this.intakeClaw = intakeClaw;
        this.intakePivot = intakePivot;
        this.intakeTurret = intakeArm;
        this.state = state;
    }

    @Override
    public void initialize() {
        switch (state) {
            case HOME:
            case INTAKE_SPEC:
            case OUTTAKE_SPEC:
            case OUTTAKE_BUCKET:
                intakeClaw.open();
                intakePivot.setPivot(IntakePivot.pivotHome);
                intakeTurret.setTurret(IntakeTurret.forward);
                break;
            case INTAKE_SUB:
                intakeClaw.open();
                intakePivot.setPivot(IntakePivot.pivotPreIntake);
                intakeTurret.setTurret(IntakeTurret.forward);
                break;
            case CAMERA_SCAN:
                intakeClaw.open();
                intakeClaw.setWrist(IntakeClaw.wristFlip);
                intakePivot.setPivot(IntakePivot.pivotScan);
                intakeTurret.setTurret(IntakeTurret.forward);
                break;
        }
    }
}
