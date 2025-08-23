package org.firstinspires.ftc.teamcode.utils.commands.outtake;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.subsystems.outtake.OuttakeArm;

public class OuttakeSetState extends CommandBase {
    private OuttakeArm outtakeArm;
    private Globals.RobotState state;

    public OuttakeSetState(OuttakeArm outtakeArm, Globals.RobotState state) {
        this.outtakeArm = outtakeArm;
        this.state = state;
    }

    @Override
    public void initialize() {
        switch (state) {
            case HOME:
            case CAMERA_SCAN:
            case INTAKE_SUB:
                outtakeArm.setArm(OuttakeArm.armHome);
                outtakeArm.setPivot(OuttakeArm.pivotHome);
                break;
            case OUTTAKE_BUCKET:
                outtakeArm.setArm(OuttakeArm.armOuttakeBucket);
                outtakeArm.setPivot(OuttakeArm.pivotOuttakeBucket);
                break;
            case OUTTAKE_SPEC:
                outtakeArm.setArm(OuttakeArm.armOuttakeSpec);
                outtakeArm.setPivot(OuttakeArm.pivotOuttakeSpec);
                break;
            case INTAKE_SPEC:
                outtakeArm.setArm(OuttakeArm.armIntakeSpec);
                outtakeArm.setPivot(OuttakeArm.pivotIntakeSpec);
                break;
        }
    }
}
