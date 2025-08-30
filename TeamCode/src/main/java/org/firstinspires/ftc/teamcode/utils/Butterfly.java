package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.Robot;

import org.firstinspires.ftc.teamcode.utils.subsystems.outtake.OuttakeArm;
import org.firstinspires.ftc.teamcode.utils.subsystems.outtake.OuttakeClaw;
import org.firstinspires.ftc.teamcode.utils.subsystems.outtake.OuttakeSlides;

public class Butterfly extends Robot {
    public enum OpModeType {
        TELEOP, AUTO
    }

    HardwareMap hMap;

    public OuttakeArm outtakeArm;
    public OuttakeClaw outtakeClaw;
    public OuttakeSlides outtakeSlides;

    public Butterfly(HardwareMap hMap, OpModeType type) {
        this.hMap = hMap;
        init();
        if (type == OpModeType.TELEOP) {
            initTele();
        } else {
            initAuto();
        }
    }

    public void init(){
        outtakeArm = new OuttakeArm(hMap, "outtakeArmLeft", "outtakeArmRight", "outtakePivot");
        outtakeClaw = new OuttakeClaw(hMap, "outtakeClaw");
        outtakeSlides = new OuttakeSlides(hMap, "liftLeft", "liftRight", "liftTouch", "liftEncoder");

        register(outtakeArm);
        register(outtakeClaw);
        register(outtakeSlides);
    }

    public void initTele() {
        // initialize teleop-specific scheduler
    }

    public void initAuto() {
        // initialize auto-specific scheduler
    }
}
