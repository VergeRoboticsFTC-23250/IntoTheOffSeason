package org.firstinspires.ftc.teamcode.utils.commands;

import com.pedropathing.follower.Follower;
import com.pedropathing.pathgen.Path;
import com.seattlesolvers.solverslib.command.CommandBase;

public class FollowPath extends CommandBase {

    private Follower follower;
    private Path path;

    public FollowPath(Follower follower, Path path) {
        this.follower = follower;
        this.path = path;
    }

    @Override
    public void initialize() {
        follower.followPath(path, true);
    }

    @Override
    public boolean isFinished() {
        return !follower.isBusy();
    }
}
