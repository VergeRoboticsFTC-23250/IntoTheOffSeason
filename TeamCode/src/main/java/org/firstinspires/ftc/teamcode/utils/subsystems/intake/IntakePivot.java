package org.firstinspires.ftc.teamcode.utils.subsystems.intake;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SimpleServo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class IntakePivot extends SubsystemBase {
    public SimpleServo servo;

    public static double home = 0.78;
    public static double preIntake = 0.17;
    public static double intake = 0.14;
    public static double scan = 0.52;

    public IntakePivot(final HardwareMap hMap, final String name) {
        this.servo = new SimpleServo(hMap, name, 0, 180, AngleUnit.DEGREES);
    }

    public InstantCommand home() {
        return new InstantCommand(() -> servo.setPosition(home));
    }

    public InstantCommand preIntake() {
        return new InstantCommand(() -> servo.setPosition(preIntake));
    }

    public InstantCommand intake() {
        return new InstantCommand(() -> servo.setPosition(intake));
    }

    public InstantCommand scan() {
        return new InstantCommand(() -> servo.setPosition(scan));
    }
}
