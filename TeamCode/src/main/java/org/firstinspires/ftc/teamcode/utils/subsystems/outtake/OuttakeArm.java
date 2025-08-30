package org.firstinspires.ftc.teamcode.utils.subsystems.outtake;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SimpleServo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class OuttakeArm extends SubsystemBase {

    public SimpleServo armLeft, armRight, pivot;

    public static double armHome = 0;
    public static double armOuttakeBucket = 0.65;
    public static double armOuttakeSubmersible = 0.24;
    public static double armIntakeWall = 0.85;
    public static double armRegrip = 0.65;

    public static double pivotHome = 0;
    public static double pivotOuttakeBucket = 0.75;
    public static double pivotOuttakeSubmersible = 0.2;
    public static double pivotIntakeWall = 0.9;
    public static double pivotRegrip = 0.9;

    public OuttakeArm(final HardwareMap hMap, final String armLeft, final String armRight, final String pivot){
        this.armLeft = new SimpleServo(hMap, armLeft, 0, 180, AngleUnit.DEGREES);
        this.armRight = new SimpleServo(hMap, armRight, 0, 180, AngleUnit.DEGREES);
        this.pivot = new SimpleServo(hMap, pivot, 0, 180, AngleUnit.DEGREES);
    }

    public InstantCommand intakeWall(){
        return new InstantCommand(() -> {
            armLeft.setPosition(armIntakeWall);
            armRight.setPosition(armIntakeWall);
            pivot.setPosition(pivotIntakeWall);
        });
    }

    public InstantCommand regrip(){
        return new InstantCommand(() -> {
            armLeft.setPosition(armRegrip);
            armRight.setPosition(armRegrip);
            pivot.setPosition(pivotRegrip);
        });
    }

    public InstantCommand submersible(){
        return new InstantCommand(() -> {
            armLeft.setPosition(armOuttakeSubmersible);
            armRight.setPosition(armOuttakeSubmersible);
            pivot.setPosition(pivotOuttakeSubmersible);
        });
    }
}
