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

    public enum OpModeType {
        AUTONOMOUS,
        TELEOP
    }

    public static OpModeType opModeType;

    public enum Color {
        RED, BLUE, YELLOW, OTHER
    }

    public static boolean isHomingOuttake = false;
    public static boolean isHomingIntake = false;

    public static boolean isScanning = false;

    public enum Alliance {
        RED,
        BLUE
    }

    public enum RobotState {
        INTAKE_WALL,
        INTAKE_SUB,
        OUTTAKE_SUB,
        OUTTAKE_BUCKET,
        SCAN
    }

    public static void init(Globals.OpModeType opModeType, OpMode opmode) { // run this BEFORE robot constructor
        Globals.opModeType = opModeType;
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
