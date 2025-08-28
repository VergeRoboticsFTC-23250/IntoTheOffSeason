package org.firstinspires.ftc.teamcode.utils.subsystems.intake;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SimpleServo;

public class IntakeClaw extends SubsystemBase {
    public SimpleServo intakeClaw, intakeWrist;
    public DigitalChannel pin0, pin1;

    public static double clawOpen = 0.29;
    public static double clawClosed = 0.465;

    public static double wristHome = 0.5;
    public static double wristNeg45 = 0.38;
    public static double wristNeg90 = 0.22;
    public static double wristPos45 = 0.62;
    public static double wristPos90 = 0.78;
    public static double wristFlip = 1.0;

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
        intakeWrist.setPosition(degrees);
    }

    public void open() {
        intakeClaw.setPosition(clawOpen);
    }

    public void close() {
        intakeClaw.setPosition(clawClosed);
    }
}
