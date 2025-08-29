package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.acmerobotics.dashboard.config.Config;
import com.pedropathing.localization.Pose;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.Robot;

@Config
@TeleOp (name = "Solo TeleOp")
public class SoloTeleOp extends CommandOpMode {

    public Robot robot;

    @Override
    public void initialize() {
        Globals.init(Globals.MatchState.TELEOP, this);
        robot = new Robot(this, new Pose(0,0,0));

        robot.intakeSlides.extendoEncoder.reset();

        register(robot.intakeSlides, robot.intakeTurret, robot.intakePivot, robot.outtakeSlides);

//        robot.intakeSlides.setPos(0);
//        robot.intakeTurret.setTurret(IntakeTurret.forward);
//        robot.intakePivot.setPivot(IntakePivot.pivotPreIntake);


    }

    @Override
    public void run() {
        robot.update();

        if (gamepad1.dpad_up) {
            robot.outtakeSlides.setPos(30000);
        }
        if (gamepad1.dpad_down) {
            robot.outtakeSlides.setPos(0);
        }


        telemetry.addData("pos", robot.outtakeSlides.liftEncoder.getPosition());
        telemetry.addData("power", robot.outtakeSlides.liftLeft.getPower());
        telemetry.update();
    }
}
