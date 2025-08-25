package org.firstinspires.ftc.teamcode.utils.commands.outtake;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.subsystems.outtake.OuttakeSlides;

public class OuttakeSlidesSetState extends CommandBase {
    private OuttakeSlides outtakeSlides;
    private Globals.RobotState state;

    public OuttakeSlidesSetState(OuttakeSlides outtakeSlides, Globals.RobotState state) {
        this.outtakeSlides = outtakeSlides;
        this.state = state;
    }

    @Override
    public void initialize() {
        switch (state) {
            case HOME:
            case INTAKE_SPEC:
            case INTAKE_SUB:
            case CAMERA_SCAN:
                outtakeSlides.setPos(OuttakeSlides.minPos);
                break;
            case OUTTAKE_BUCKET:
                outtakeSlides.setPos(OuttakeSlides.highBucket);
            case OUTTAKE_SPEC:
                outtakeSlides.setPos(OuttakeSlides.specScore);
        }
    }

    @Override
    public boolean isFinished() {
        return outtakeSlides.controller.atSetPoint();
    }
}