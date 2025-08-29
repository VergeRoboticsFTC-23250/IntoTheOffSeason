package org.firstinspires.ftc.teamcode.utils.commands.drivetrain;

import com.acmerobotics.dashboard.config.Config;
import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.subsystems.Drivetrain;

@Config
public class TeleOpDrive extends CommandBase {
    private static final double slowSpeed = 0.5;
    private Drivetrain drivetrain;

    public TeleOpDrive(Drivetrain drivetrain, GamepadEx gamepad) {
        this.drivetrain = drivetrain;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.follower.startTeleopDrive();
    }

    @Override
    public void execute() {
        boolean slow = Globals.vivek.getButton(GamepadKeys.Button.LEFT_BUMPER);

        if (slow) {
            drivetrain.follower.setTeleOpMovementVectors(
                    -Globals.vivek.getLeftY() * slowSpeed,
                    -Globals.vivek.getLeftX() * slowSpeed,
                    -Globals.vivek.getRightX() * slowSpeed, true);
        } else {
            drivetrain.follower.setTeleOpMovementVectors(
                    -Globals.vivek.getLeftY(),
                    -Globals.vivek.getLeftX(),
                    -Globals.vivek.getRightX(), true);
        }
        drivetrain.follower.update();
    }
}
