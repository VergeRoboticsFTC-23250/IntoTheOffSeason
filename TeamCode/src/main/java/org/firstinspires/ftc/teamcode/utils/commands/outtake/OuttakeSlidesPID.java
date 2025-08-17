package org.firstinspires.ftc.teamcode.utils.commands.outtake;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.utils.subsystems.outtake.OuttakeSlides;

public class OuttakeSlidesPID extends CommandBase {
    private OuttakeSlides outtakeSlides;
    private double position;

    public OuttakeSlidesPID(OuttakeSlides outtakeSlides, double position) {
        this.outtakeSlides = outtakeSlides;
        this.position = position;
    }

    @Override
    public void initialize() {
        outtakeSlides.controller.setSetPoint(position);
    }

    @Override
    public boolean isFinished() {
        return outtakeSlides.controller.atSetPoint();
    }
}
