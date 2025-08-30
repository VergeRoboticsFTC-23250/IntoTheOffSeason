package org.firstinspires.ftc.teamcode.utils.subsystems.outtake;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.Command;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SimpleServo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class OuttakeClaw extends SubsystemBase {
    public SimpleServo grippers;

    public static double open = 0;
    public static double closeFirm = 0.2;
    public static double closeLoose = 0.125;

    public OuttakeClaw(final HardwareMap hMap, final String grippers){
        this.grippers = new SimpleServo(hMap, grippers, 0, 180, AngleUnit.DEGREES);
    }

    public InstantCommand open(){
        return new InstantCommand(() -> grippers.setPosition(open));
    };

    public InstantCommand closeFirm(){
        return new InstantCommand(() -> grippers.setPosition(closeFirm));
    }

    public InstantCommand closeLoose(){
        return new InstantCommand(() -> grippers.setPosition(closeLoose));
    }
}
