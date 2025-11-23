package org.firstinspires.ftc.teamcode;


import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.bosch.BHI260IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;
import org.firstinspires.ftc.robotcore.external.ExportToBlocks;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
//import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

import java.lang.Math;
public class EZ_Drivetrain extends BlocksOpModeCompanion {
    private static SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);



    @ExportToBlocks(
            parameterLabels = "Using Dashboard?,Back Left,Back Right,Front Left,Front Right,Strafe,Fwd,Turn"
    )
    public static void EZMecanum_Robot_Centric(boolean dash, String bL, String bR, String fL, String fR, double strafe, double fwd, double turn){
        Motor backLeft = new Motor(hardwareMap, bL);
        Motor backRight = new Motor(hardwareMap, bR);
        backRight.setInverted(true);
        Motor frontLeft = new Motor(hardwareMap, fL);
        Motor frontRight = new Motor(hardwareMap, fR);
        frontRight.setInverted(true);
        MecanumDrive mecanum = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
        mecanum.driveRobotCentric(strafe, fwd, turn);
    }
    @ExportToBlocks(
            parameterLabels = "Using Dashboard?,Back Left,Back Right,Front Left,Front Right,Strafe,Fwd,Turn"
    )
    public static void EZMecanum_Field_Centric(boolean dash, String bL, String bR, String fL, String fR, double strafe, double fwd, double turn){
        Motor backLeft = new Motor(hardwareMap, bL);
        Motor backRight = new Motor(hardwareMap, bR);
        backRight.setInverted(true);
        Motor frontLeft = new Motor(hardwareMap, fL);
        Motor frontRight = new Motor(hardwareMap, fR);
        frontRight.setInverted(true);
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        double heading = Math.toDegrees(drive.getExternalHeading());
        MecanumDrive mecanum = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
        mecanum.driveFieldCentric(strafe, fwd, turn, heading);
    }





}