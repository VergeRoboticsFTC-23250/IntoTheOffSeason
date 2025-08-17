package org.firstinspires.ftc.teamcode.utils.commands.intake;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakeSlides;

public class IntakeSlidesHome extends CommandBase {
    private IntakeSlides intakeSlides;
    private double speed = -0.3;

    public IntakeSlidesHome(IntakeSlides intakeSlides) {
        this.intakeSlides = intakeSlides;
    }

    @Override
    public void initialize() {
        intakeSlides.extendoLeft.setPower(speed);
        intakeSlides.extendoRight.setPower(speed);
    }

    @Override
    public boolean isFinished() {
        return intakeSlides.touch.isPressed();
    }

    @Override
    public void end(boolean interrupted) {
        intakeSlides.extendoLeft.setPower(0);
        intakeSlides.extendoRight.setPower(0);
        intakeSlides.extendoEncoder.reset();
    }
}
