package org.firstinspires.ftc.teamcode.utils.subsystems.intake;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.utils.TurretServo;

public class IntakeTurret extends SubsystemBase {
    public TurretServo servo;

    public static double transfer = 0.905;
    public static double dropSamp = 0;
    public static double forward = 0.36;

    public static final double ARM_LENGTH_IN = 6.8722440945; // inches

    public double theta_deg = 0;

    public IntakeTurret(final HardwareMap hMap, final String name) {
        this.servo = new TurretServo(hMap, name, 0, 180, AngleUnit.DEGREES);
    }

    public InstantCommand setAngle(double angle){
        return new InstantCommand(() -> {
            servo.setPosition(angle);

            if (angle == forward) theta_deg = 0;
        });
    }

    public InstantCommand rotateAngle(double angle){
        return new InstantCommand(() -> {
            servo.rotateByAngle(angle);
        });
    }

    public double calcTheta(double x) {
        theta_deg = Math.toDegrees(Math.asin(x / ARM_LENGTH_IN));
        return theta_deg;
    }

    public InstantCommand forward(){
        return new InstantCommand(() -> servo.setPosition(forward));
    }

    public InstantCommand dropSamp(){
        return new InstantCommand(() -> servo.setPosition(dropSamp));
    }

    public InstantCommand transfer(){
        return new InstantCommand(() -> servo.setPosition(transfer));
    }
}
