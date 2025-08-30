package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.acmerobotics.dashboard.config.Config;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.utils.Butterfly;

@Config
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp")
public class TeleOp extends CommandOpMode {

    Butterfly robot;

    @Override
    public void initialize() {
        robot = new Butterfly(hardwareMap, Butterfly.OpModeType.TELEOP);
    }

    @Override
    public void run() {
        if(gamepad1.cross){
            schedule(new SequentialCommandGroup(
                    robot.outtakeArm.intakeSpec(),
                    robot.outtakeClaw.open()
            ));
        }

        if(gamepad1.triangle){
            schedule(new SequentialCommandGroup(
                    robot.outtakeArm.regrip(),
                    robot.outtakeClaw.closeLoose(),
                    robot.outtakeSlides.setPos(5000)
            ));
        }
        robot.run();
    }
}
