package org.firstinspires.ftc.teamcode.utils.commands.drivetrain;

import com.acmerobotics.dashboard.config.Config;
import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.command.CommandScheduler;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.pedroPathing.constants.FConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.LConstants;
import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.Robot;
import org.firstinspires.ftc.teamcode.utils.subsystems.Drivetrain;

@Config
public class TeleOpDrive extends CommandBase {
    private static final double slowSpeed = 0.5;
    private Drivetrain drivetrain;

    public TeleOpDrive(Drivetrain drivetrain, GamepadEx gamepad) {
        this.drivetrain = drivetrain;
    }

    @Override
    public void initialize() {
        drivetrain.follower.startTeleopDrive();
    }

    @Override
    public void execute() {
        boolean slow = Globals.arvind.getButton(GamepadKeys.Button.LEFT_BUMPER);

        if (slow) {
            drivetrain.follower.setTeleOpMovementVectors(
                    -Globals.arvind.getLeftY() * slowSpeed,
                    -Globals.arvind.getLeftX() * slowSpeed,
                    -Globals.arvind.getRightX() * slowSpeed, true);
        } else {
            drivetrain.follower.setTeleOpMovementVectors(
                    -Globals.arvind.getLeftY(),
                    -Globals.arvind.getLeftX(),
                    -Globals.arvind.getRightX(), true);
        }
        drivetrain.follower.update();
    }
}
