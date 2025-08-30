package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.acmerobotics.dashboard.config.Config;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.command.WaitCommand;
import com.seattlesolvers.solverslib.command.WaitUntilCommand;

import org.firstinspires.ftc.teamcode.utils.Butterfly;
import org.firstinspires.ftc.teamcode.utils.Globals;

@Config
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp")
public class TeleOp extends CommandOpMode {

    Butterfly robot;

    @Override
    public void initialize() {
        robot = new Butterfly(hardwareMap, Globals.OpModeType.TELEOP);
    }

    @Override
    public void run() {
//        if(gamepad1.cross){
//            schedule(new SequentialCommandGroup(
//                    robot.outtakeArm.intakeSpec(),
//                    robot.outtakeClaw.open(),
//                    robot.outtakeSlides.home()
//            ));
//        }
//
//        if(gamepad1.triangle){
//            schedule(new SequentialCommandGroup(
//                    robot.outtakeClaw.closeLoose(),
//                    robot.outtakeArm.regrip(),
//                    robot.outtakeSlides.submersible(),
//                    robot.outtakeClaw.closeFirm(),
//                    robot.outtakeArm.submersible()
//            ));
//        }

        if(gamepad1.cross){
            schedule(robot.intakeSlides.home());
        }

        if(gamepad1.triangle){
            schedule(robot.intakeSlides.half());
        }
        robot.run();
    }
}
