package org.firstinspires.ftc.teamcode.utils.subsystems;

import com.pedropathing.follower.Follower;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.utils.Globals;
import org.firstinspires.ftc.teamcode.utils.Robot;
import org.firstinspires.ftc.teamcode.utils.commands.drivetrain.TeleOpDrive;

public class Drivetrain extends SubsystemBase {
    public Follower follower;

    public Drivetrain(Follower follower, Globals.MatchState state) {
        this.follower = follower;

        if (state.equals(Globals.MatchState.TELEOP)) {
            setDefaultCommand(new TeleOpDrive(this, Globals.arvind));
        }
    }
}