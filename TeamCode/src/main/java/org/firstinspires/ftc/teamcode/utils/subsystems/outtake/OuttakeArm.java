package org.firstinspires.ftc.teamcode.utils.subsystems.outtake;

import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SimpleServo;

public class OuttakeArm extends SubsystemBase {

    public SimpleServo outtakeArmLeft, outtakeArmRight, outtakePivot;

    public static double armHome = 0;
    public static double armOuttakeBucket = 0.65;
    public static double armOuttakeSpec = 0.22;
    public static double armIntakeSpec = 0.84;

    public static double pivotHome = 0;
    public static double pivotOuttakeBucket = 0.75;
    public static double pivotOuttakeSpec = 0.15;
    public static double pivotIntakeSpec = 0.2;

    public OuttakeArm(SimpleServo outtakeArmLeft, SimpleServo outtakeArmRight, SimpleServo outtakePivot) {
        this.outtakeArmLeft = outtakeArmLeft;
        this.outtakeArmRight = outtakeArmRight;
        this.outtakePivot = outtakePivot;
    }

    public void setArm(double pos) {
        outtakeArmLeft.setPosition(pos);
        outtakeArmRight.setPosition(pos);
    }

    public void setPivot(double pos) {
        outtakePivot.setPosition(pos);
    }
}
