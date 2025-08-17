package org.firstinspires.ftc.teamcode.utils.commands.outtake;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.subsystems.outtake.OuttakeSlides;

public class OuttakeSlidesHome extends CommandBase {
    private OuttakeSlides outtakeSlides;
    private double speed = -0.3;

    public OuttakeSlidesHome(OuttakeSlides outtakeSlides) {
        this.outtakeSlides = outtakeSlides;
    }

    @Override
    public void initialize() {
        outtakeSlides.liftLeft.setPower(speed);
        outtakeSlides.liftRight.setPower(speed);

        Globals.isHomingOuttake = true;
    }

    @Override
    public boolean isFinished() {
        return outtakeSlides.touch.isPressed();
    }

    @Override
    public void end(boolean interrupted) {
        outtakeSlides.liftLeft.setPower(0);
        outtakeSlides.liftRight.setPower(0);
        outtakeSlides.liftEncoder.reset();
    }
}
