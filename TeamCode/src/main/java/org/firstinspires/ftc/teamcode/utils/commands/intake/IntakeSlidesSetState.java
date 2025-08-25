package org.firstinspires.ftc.teamcode.utils.commands.intake;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakeSlides;

public class IntakeSlidesSetState extends CommandBase {
    private IntakeSlides intakeSlides;
    private Globals.RobotState state;

    public IntakeSlidesSetState(IntakeSlides intakeSlides, Globals.RobotState state) {
        this.intakeSlides = intakeSlides;
        this.state = state;
    }

    @Override
    public void initialize() {
        switch (state) {
            case HOME:
            case INTAKE_SPEC:
            case OUTTAKE_BUCKET:
            case OUTTAKE_SPEC:
                intakeSlides.setPos(IntakeSlides.minPos);
                break;
            case CAMERA_SCAN:
            case INTAKE_SUB:
                intakeSlides.setPos(IntakeSlides.maxPos);
                break;
        }
    }

    @Override
    public boolean isFinished() {
        return intakeSlides.controller.atSetPoint();
    }
}
