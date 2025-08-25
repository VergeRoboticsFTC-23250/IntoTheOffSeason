package org.firstinspires.ftc.teamcode.utils.subsystems.intake;

import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.utils.TurretServo;

public class IntakeTurret extends SubsystemBase {
    public TurretServo intakeTurret;

    public static double back = 0.76;
    public static double deposit = 0.95;
    public static double forward = 0.205;

    public IntakeTurret(TurretServo intakeTurret) {
        this.intakeTurret = intakeTurret;
    }

    public void setTurret(double degrees) {
        intakeTurret.turnToAngle(degrees);
    }

    public void rotate(double degrees) {
        intakeTurret.rotateByAngle(degrees);
    }
}
