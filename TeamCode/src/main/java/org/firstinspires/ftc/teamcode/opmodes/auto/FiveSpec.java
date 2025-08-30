package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.utils.Butterfly;
import org.firstinspires.ftc.teamcode.utils.Commands;
import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.Paths;
import org.firstinspires.ftc.teamcode.utils.commands.FollowPath;

@Autonomous(name = "FiveSpec")
public class FiveSpec extends CommandOpMode {
    Butterfly robot;

    @Override
    public void initialize() {
        Globals.init(Globals.OpModeType.AUTONOMOUS, this);
        robot = new Butterfly(hardwareMap, Globals.OpModeType.AUTONOMOUS);
        Commands.init(robot);
        robot.drivetrain.follower.setStartingPose(Paths.startPose);
        Paths.init();

        schedule(new SequentialCommandGroup(
                //Commands.outtakeSub
                new FollowPath(robot.drivetrain.follower, Paths.fiveSpec[0])
        ));
    }

    @Override
    public void run() {
        robot.drivetrain.follower.update();
    }
}
