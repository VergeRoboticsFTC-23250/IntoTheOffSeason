package org.firstinspires.ftc.teamcode.utils.subsystems.outtake;

import com.acmerobotics.dashboard.config.Config;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SimpleServo;

@Config
public class OuttakeClaw extends SubsystemBase {
    public SimpleServo outtakeClaw;

    public static double open = 0;
    public static double closed = 0.2;
    public static double loose = 0.15; // not done

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
