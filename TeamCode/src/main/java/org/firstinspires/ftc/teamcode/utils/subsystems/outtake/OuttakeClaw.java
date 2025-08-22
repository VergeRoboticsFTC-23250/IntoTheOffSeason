package org.firstinspires.ftc.teamcode.utils.subsystems.outtake;

import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SimpleServo;

public class OuttakeClaw extends SubsystemBase {
    public SimpleServo outtakeClaw;

    public static double open = 0;
    public static double closed = 0;
    public static double loose = 0;

    public OuttakeClaw(SimpleServo outtakeClaw) {
        this.outtakeClaw = outtakeClaw;
    }

    public void open() {
        outtakeClaw.turnToAngle(open);
    }

    public void close() {
        outtakeClaw.turnToAngle(closed);
    }

    public void loose() {
        outtakeClaw.turnToAngle(loose);
    }
}
