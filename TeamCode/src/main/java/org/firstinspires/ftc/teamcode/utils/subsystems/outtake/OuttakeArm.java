package org.firstinspires.ftc.teamcode.utils.subsystems.outtake;

import com.acmerobotics.dashboard.config.Config;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SimpleServo;

@Config
public class OuttakeArm extends SubsystemBase {

    public SimpleServo outtakeArmLeft, outtakeArmRight, outtakePivot;

    public static double armHome = 0;
    public static double armOuttakeBucket = 0.65;
    public static double armOuttakeSpec = 0.24;
    public static double armIntakeSpec = 0.85;
    public static double armRegrip = 0.65;

    public static double pivotHome = 0;
    public static double pivotOuttakeBucket = 0.75;
    public static double pivotOuttakeSpec = 0.2;
    public static double pivotIntakeSpec = 0.9;
    public static double pivotRegrip = 0.9;

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
