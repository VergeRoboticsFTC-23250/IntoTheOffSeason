package org.firstinspires.ftc.teamcode.utils.subsystems.outtake;

import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SimpleServo;

public class OuttakeArm extends SubsystemBase {

    public SimpleServo outtakeArmLeft, outtakeArmRight, outtakePivot;

    public OuttakeArm(SimpleServo outtakeArmLeft, SimpleServo outtakeArmRight, SimpleServo outtakePivot) {
        this.outtakeArmLeft = outtakeArmLeft;
        this.outtakeArmRight = outtakeArmRight;
        this.outtakePivot = outtakePivot;
    }

    public void setArm(double pos) {
        outtakeArmLeft.turnToAngle(pos);
        outtakeArmRight.turnToAngle(pos);
    }

    public void setPivot(double pos) {
        outtakePivot.turnToAngle(pos);
    }
}
