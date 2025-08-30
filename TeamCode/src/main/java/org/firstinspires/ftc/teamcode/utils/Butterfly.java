package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.ParallelCommandGroup;
import com.seattlesolvers.solverslib.command.Robot;

import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakeClaw;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakePivot;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakeSlides;
import org.firstinspires.ftc.teamcode.utils.subsystems.intake.IntakeTurret;
import org.firstinspires.ftc.teamcode.utils.subsystems.outtake.OuttakeArm;
import org.firstinspires.ftc.teamcode.utils.subsystems.outtake.OuttakeClaw;
import org.firstinspires.ftc.teamcode.utils.subsystems.outtake.OuttakeSlides;

public class Butterfly extends Robot {
    HardwareMap hMap;

    public OuttakeArm outtakeArm;
    public OuttakeClaw outtakeClaw;
    public OuttakeSlides outtakeSlides;
    public IntakeSlides intakeSlides;
    public IntakeClaw intakeClaw;
    public IntakePivot intakePivot;
    public IntakeTurret intakeTurret;
    public Butterfly(HardwareMap hMap, Globals.OpModeType type) {
        this.hMap = hMap;
        init();
        if (type == Globals.OpModeType.TELEOP) {
            initTele();
        } else {
            initAuto();
        }
    }

    public void init(){
        outtakeArm = new OuttakeArm(hMap, "outtakeArmLeft", "outtakeArmRight", "outtakePivot");
        outtakeClaw = new OuttakeClaw(hMap, "outtakeClaw");
        outtakeSlides = new OuttakeSlides(hMap, "liftLeft", "liftRight", "liftTouch", "liftEncoder");

        intakeSlides = new IntakeSlides(hMap, "extendo", "extendoTouch", "extendo");
        intakeClaw = new IntakeClaw(hMap, "intakeClaw", "intakeWrist", "pin0", "pin1");
        intakePivot = new IntakePivot(hMap, "intakePivot");
        intakeTurret = new IntakeTurret(hMap, "intakeTurret");

        register(outtakeArm);
        register(outtakeClaw);
        register(outtakeSlides);

        register(intakeSlides);
        register(intakeClaw);
        register(intakePivot);

        schedule(new ParallelCommandGroup(
                this.intakeSlides.home(),
                this.intakeTurret.forward(),
                this.intakePivot.home(),
                this.intakeClaw.home(),
                this.intakeClaw.open(),

                this.outtakeSlides.home(),
                this.outtakeArm.intakeWall(),
                this.outtakeClaw.open()
        ));
    }

    public void initTele() {
        // initialize teleop-specific scheduler
    }

    public void initAuto() {
        // initialize auto-specific scheduler
    }
}
