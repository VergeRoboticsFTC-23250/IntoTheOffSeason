package org.firstinspires.ftc.teamcode.utils;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class Globals {
    public static Telemetry telemetry;
    public static HardwareMap hMap;
//    public static GamepadEx arvind;
    public static GamepadEx vivek;

    public static MatchState matchState;
    public enum MatchState {
        AUTONOMOUS,
        TELEOP
    }

    public static boolean isHomingOuttake = false;
    public static boolean isHomingIntake = false;

    public static boolean isScanning = false;

    public enum Alliance {
        RED,
        BLUE
    }

    public enum RobotState {
        HOME,
        INTAKE_SPEC,
        INTAKE_SUB,
        OUTTAKE_SPEC,
        OUTTAKE_BUCKET,
        SPEC_REGRIP,
        CAMERA_SCAN
    }

    public static void init(MatchState state, OpMode opmode) { // run this BEFORE robot constructor
        matchState = state;
        hMap = opmode.hardwareMap;
        telemetry = opmode.telemetry;
//        arvind = new GamepadEx(opmode.gamepad1);
        vivek = new GamepadEx(opmode.gamepad2);
    }

    public static void update(OpMode opMode) {
//        arvind = new GamepadEx(opMode.gamepad1);
        vivek = new GamepadEx(opMode.gamepad2);
    }
}
