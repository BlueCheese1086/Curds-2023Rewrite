// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    private final TalonSRX frontLeft = new TalonSRX(1);
    private final TalonSRX frontRight = new TalonSRX(2);
    private final TalonSRX backLeft = new TalonSRX(3);
    private final TalonSRX backRight = new TalonSRX(4);

    /** Creates a new Drivetrain. */
    public Drivetrain() {
        frontLeft.setInverted(true);
        backLeft.setInverted(true);
    }

    // Takes input from a joystick and finds the speed each motor should go at.
    public void arcadeDrive(double xSpeed, double zRotation) {
        xSpeed = MathUtil.applyDeadband(xSpeed, Constants.deadband);
        zRotation = MathUtil.applyDeadband(zRotation, Constants.deadband);

        var speeds = DifferentialDrive.arcadeDriveIK(xSpeed, zRotation, Constants.squareInputs);

        setSpeeds(speeds.left, speeds.right, speeds.left, speeds.right);
    }

    // Sets the speed of the robot.
    public void setSpeeds(double frontLeftSpeed, double frontRightSpeed, double backLeftSpeed, double backRightSpeed){
        frontLeft.set(ControlMode.PercentOutput, frontLeftSpeed * Constants.maxSpeed);
        frontRight.set(ControlMode.PercentOutput, frontRightSpeed * Constants.maxSpeed);
        backLeft.set(ControlMode.PercentOutput, backLeftSpeed * Constants.maxSpeed);
        backRight.set(ControlMode.PercentOutput, backRightSpeed * Constants.maxSpeed);
    }
}