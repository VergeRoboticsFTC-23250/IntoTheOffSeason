package org.firstinspires.ftc.teamcode.utils.subsystems.intake;

import com.acmerobotics.dashboard.config.Config;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.utils.TurretServo;

@Config
public class IntakeTurret extends SubsystemBase {
    public TurretServo intakeTurret;

    public static double back = 0.905;
    public static double deposit = 0;
    public static double forward = 0.36;

    public static final double ARM_LENGTH_IN = 6.8722440945; // inches

    public double theta_deg = 0;

    public IntakeTurret(TurretServo intakeTurret) {
        this.intakeTurret = intakeTurret;
    }

    public void setTurret(double degrees) {
        intakeTurret.setPosition(degrees);

        if (degrees == forward) theta_deg = 0;
    }

    public void rotate(double degrees) {
        intakeTurret.rotateByAngle(degrees);
    }

    public double calcTheta(double x) {
        theta_deg = Math.toDegrees(Math.asin(x / ARM_LENGTH_IN));
        return theta_deg;
    }
}
