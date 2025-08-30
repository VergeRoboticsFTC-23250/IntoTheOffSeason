package org.firstinspires.ftc.teamcode.utils.subsystems.intake;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SimpleServo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.utils.Globals;

public class IntakeClaw extends SubsystemBase {
    public SimpleServo grippers, wrist;
    public DigitalChannel pin0, pin1;

    public static double open = 0.29;
    public static double close = 0.465;

    public static double home = 0.5;
    public static double neg45 = 0.38;
    public static double neg90 = 0.22;
    public static double pos45 = 0.62;
    public static double pos90 = 0.78;
    public static double wristFlip = 1.0;

    public IntakeClaw(final HardwareMap hMap, final String grippers, final String wrist, final String pin0, final String pin1) {
        this.grippers = new SimpleServo(hMap, grippers, 0, 180, AngleUnit.DEGREES);;
        this.wrist = new SimpleServo(hMap, wrist, 0, 180, AngleUnit.DEGREES);
        this.pin0 = hMap.get(DigitalChannel.class, pin0);
        this.pin1 = hMap.get(DigitalChannel.class, pin1);
    }

    public Globals.Color getColor() {
        if (pin0.getState() && pin1.getState()) {
            return Globals.Color.YELLOW;
        } else if (!pin0.getState() && pin1.getState()) {
            return Globals.Color.RED;
        } else if (pin0.getState() && !pin1.getState()) {
            return Globals.Color.BLUE;
        } else {
            return Globals.Color.OTHER;
        }
    }

    public InstantCommand rotateAngle(double degrees) {
        return new InstantCommand(() -> wrist.rotateByAngle(degrees));
    }

    public InstantCommand rotatePos(double degrees) {
        return new InstantCommand(() -> wrist.setPosition(degrees));
    }

    public InstantCommand home() {
        return new InstantCommand(() -> wrist.setPosition(home));
    }

    public InstantCommand open() {
        return new InstantCommand(() -> grippers.setPosition(open));
    }

    public InstantCommand close() {
        return new InstantCommand(() -> grippers.setPosition(close));
    }
}
