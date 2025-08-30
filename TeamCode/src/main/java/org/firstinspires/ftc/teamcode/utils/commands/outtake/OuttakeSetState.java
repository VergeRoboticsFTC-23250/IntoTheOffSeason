package org.firstinspires.ftc.teamcode.utils.commands.outtake;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.subsystems.outtake.OuttakeArm;
import org.firstinspires.ftc.teamcode.utils.subsystems.outtake.OuttakeClaw;

public class OuttakeSetState extends CommandBase {
    private OuttakeArm outtakeArm;
    private OuttakeClaw outtakeClaw;
    private Globals.RobotState state;

    public OuttakeSetState(OuttakeArm outtakeArm, OuttakeClaw claw, Globals.RobotState state) {
        this.outtakeArm = outtakeArm;
        this.outtakeClaw = claw;
        this.state = state;
    }

    @Override
    public void initialize() {
        switch (state) {
            case OUTTAKE_BUCKET:
                outtakeClaw.close();
                outtakeArm.setArm(OuttakeArm.armOuttakeBucket);
                outtakeArm.setPivot(OuttakeArm.pivotOuttakeBucket);
                break;
            case OUTTAKE_SPEC:
                outtakeClaw.close();
                outtakeArm.setArm(OuttakeArm.armOuttakeSpec);
                outtakeArm.setPivot(OuttakeArm.armOuttakeSpec);
                break;
            case SPEC_REGRIP:
                outtakeClaw.loose();
                outtakeArm.setArm(OuttakeArm.armRegrip);
                outtakeArm.setPivot(OuttakeArm.pivotRegrip);
                break;
            case HOME:
            case CAMERA_SCAN:
            case INTAKE_SUB:
            case INTAKE_SPEC:
                outtakeClaw.open();
                outtakeArm.setArm(OuttakeArm.armIntakeSpec);
                outtakeArm.setPivot(OuttakeArm.pivotIntakeSpec);
                break;
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
