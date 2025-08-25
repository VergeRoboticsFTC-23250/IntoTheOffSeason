package org.firstinspires.ftc.teamcode.utils.commands.intake;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakeSlides;

public class IntakeSlidesPID extends CommandBase {
    private IntakeSlides intakeSlides;
    private double position;

    public IntakeSlidesPID(IntakeSlides intakeSlides, double position) {
        this.intakeSlides = intakeSlides;
        this.position = position;
    }

    @Override
    public void initialize() {
        intakeSlides.setPos(position);
    }

    @Override
    public boolean isFinished() {
        return intakeSlides.controller.atSetPoint();
    }
}
