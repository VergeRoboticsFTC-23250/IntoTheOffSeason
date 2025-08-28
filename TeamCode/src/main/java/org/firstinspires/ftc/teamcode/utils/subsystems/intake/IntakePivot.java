package org.firstinspires.ftc.teamcode.utils.subsystems.intake;

import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SimpleServo;

public class IntakePivot extends SubsystemBase {
    public SimpleServo intakePivot;

    public static double pivotHome = 0.78; //TODO make this straight up
    public static double pivotPreIntake = 0.17;
    public static double pivotIntake = 0.14;
    public static double pivotScan = 0.52;

    public IntakePivot(SimpleServo intakePivot) {
        this.intakePivot = intakePivot;
    }

    public void setPivot(double degrees) {
        intakePivot.setPosition(degrees);
    }
}
