package org.firstinspires.ftc.teamcode.utils.subsystems.intake;

import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SimpleServo;

public class IntakePivot extends SubsystemBase {
    public SimpleServo intakePivot;

    public IntakePivot(SimpleServo intakePivot) {
        this.intakePivot = intakePivot;
    }

    public void setPivot(double degrees) {
        intakePivot.turnToAngle(degrees);
    }
}
