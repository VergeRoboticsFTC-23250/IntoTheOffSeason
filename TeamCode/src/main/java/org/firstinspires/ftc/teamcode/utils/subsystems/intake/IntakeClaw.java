package org.firstinspires.ftc.teamcode.utils.subsystems.intake;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SimpleServo;

public class IntakeClaw extends SubsystemBase {
    public SimpleServo intakeClaw, intakeWrist;
    public DigitalChannel pin0, pin1;

    public static double open = 0;
    public static double closed = 0;

    public enum Color {
        RED, BLUE, YELLOW, OTHER
    }

    public IntakeClaw(SimpleServo intakeClaw, SimpleServo intakeWrist,
                     DigitalChannel pin0, DigitalChannel pin1) {
        this.intakeClaw = intakeClaw;
        this.intakeWrist = intakeWrist;
        this.pin0 = pin0;
        this.pin1 = pin1;
    }

    public Color getColor() {
        if (pin0.getState() && pin1.getState()) {
            return Color.YELLOW;
        } else if (!pin0.getState() && pin1.getState()) {
            return Color.RED;
        } else if (pin0.getState() && !pin1.getState()) {
            return Color.BLUE;
        } else {
            return Color.OTHER;
        }
    }

    public void rotate(double degrees) {
        intakeWrist.rotateByAngle(degrees);
    }

    public void setWrist(double degrees) {
        intakeWrist.turnToAngle(degrees);
    }

    public void open() {
        intakeClaw.turnToAngle(open);
    }

    public void close() {
        intakeClaw.turnToAngle(closed);
    }
}
