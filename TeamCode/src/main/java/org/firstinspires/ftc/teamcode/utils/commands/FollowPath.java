package org.firstinspires.ftc.teamcode.utils.commands;

import com.pedropathing.follower.Follower;
import com.pedropathing.pathgen.Path;
import com.seattlesolvers.solverslib.command.CommandBase;

public class FollowPath extends CommandBase {

    private final Follower follower;
    private final Path path;
    private Thread thread;
    private volatile boolean done = false;

    public FollowPath(Follower follower, Path path) {
        this.follower = follower;
        this.path = path;
    }

    @Override
    public void initialize() {
        done = false;

        // Start background thread
        thread = new Thread(() -> {
            follower.followPath(path, true);

            while (follower.isBusy() && !Thread.currentThread().isInterrupted()) {
                follower.update();   // keep follower alive
                try {
                    Thread.sleep(20); // ~50Hz update
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            done = true; // finished path
        });

        thread.start();
    }

    @Override
    public boolean isFinished() {
        return done;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted && thread != null && thread.isAlive()) {
            thread.interrupt();
        }
    }
}