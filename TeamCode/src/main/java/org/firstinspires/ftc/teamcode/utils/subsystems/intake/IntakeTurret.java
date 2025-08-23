package org.firstinspires.ftc.teamcode.utils.subsystems.intake;

import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SimpleServo;

public class IntakeTurret extends SubsystemBase {
    public SimpleServo intakeTurret;

    public static double back = 0.76;
    public static double deposit = 0.95;
    public static double forward = 0.205;

    public IntakeTurret(SimpleServo intakeTurret) {
        this.intakeTurret = intakeTurret;
    }

    public void setTurret(double degrees) {
        intakeTurret.turnToAngle(degrees);
    }

    public void rotate(double degrees) {
        intakeTurret.rotateByAngle(degrees);
    }
}
