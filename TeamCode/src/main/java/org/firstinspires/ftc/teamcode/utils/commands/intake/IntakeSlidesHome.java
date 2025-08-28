package org.firstinspires.ftc.teamcode.utils.commands.intake;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakeSlides;

public class IntakeSlidesHome extends CommandBase {
    private IntakeSlides intakeSlides;
    private double speed = -0.5;

    public IntakeSlidesHome(IntakeSlides intakeSlides) {
        this.intakeSlides = intakeSlides;
    }

    @Override
    public void initialize() {
        intakeSlides.extendo.setPower(speed);
    }

    @Override
    public boolean isFinished() {
        return intakeSlides.touch.isPressed();
    }

    @Override
    public void end(boolean interrupted) {
        intakeSlides.extendo.setPower(0);
        intakeSlides.extendoEncoder.reset();
    }
}
