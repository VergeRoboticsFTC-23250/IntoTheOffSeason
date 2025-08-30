package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.pedroCommand.FollowPathCommand;

import org.firstinspires.ftc.teamcode.utils.Butterfly;
import org.firstinspires.ftc.teamcode.utils.Commands;
import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.Paths;

@Autonomous(name = "FiveSpec")
public class FiveSpec extends CommandOpMode {

    Butterfly robot;

    @Override
    public void initialize() {
        robot = new Butterfly(hardwareMap, Globals.OpModeType.AUTONOMOUS);
        Commands.init(robot);

        schedule(
                new SequentialCommandGroup(
                    robot.drivetrain.follow(Paths.fiveSpec[0]),
                        robot.drivetrain.follow(Paths.fiveSpec[1])
                )
        );
    }

    @Override
    public void run() {
        robot.run();
    }
}
