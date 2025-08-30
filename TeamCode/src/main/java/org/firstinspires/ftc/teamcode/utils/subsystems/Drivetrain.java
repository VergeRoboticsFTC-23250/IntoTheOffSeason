package org.firstinspires.ftc.teamcode.utils.subsystems;

import com.pedropathing.follower.Follower;
import com.pedropathing.pathgen.Path;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.Command;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.pedroCommand.FollowPathCommand;

import org.firstinspires.ftc.teamcode.pedroPathing.constants.FConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.LConstants;

public class Drivetrain extends SubsystemBase {
    public Follower follower;

    public Drivetrain(final HardwareMap hMap){
        follower = new Follower(hMap, FConstants.class, LConstants.class);
    }

//    @Override
//    public void periodic() {
//        follower.update();
//    }

//    public Command follow(Path path, final boolean holdEnd){
//        return new FollowPathCommand(
//                follower,
//                path, holdEnd
//        );
//    }

    public Command follow(Path path){
        return new FollowPathCommand(follower, path,true);
    }
}
