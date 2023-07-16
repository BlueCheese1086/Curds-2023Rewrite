// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private final TalonSRX frontLeft = new TalonSRX(1);
    private final TalonSRX frontRight = new TalonSRX(2);
    private final TalonSRX backLeft = new TalonSRX(3);
    private final TalonSRX backRight = new TalonSRX(4);

    private final boolean squareInputs = false;
    private final double deadband = 0.02;
    private final double maxSpeed = 0.25;

    /** Creates a new Drivetrain. */
    public Drivetrain() {
        frontLeft.setInverted(true);
        backLeft.setInverted(true);
    }

    // Moves the robot with Joystick input.
    public void arcadeDrive(double xSpeed, double zRotation) {

        xSpeed = MathUtil.applyDeadband(xSpeed, deadband);
        zRotation = MathUtil.applyDeadband(zRotation, deadband);

        var speeds = DifferentialDrive.arcadeDriveIK(xSpeed, zRotation, squareInputs);

        setSpeeds(speeds.left, speeds.right, speeds.left, speeds.right);
    }

    // Sets the speed of each motor.
    public void setSpeeds(double frontLeftSpeed, double frontRightSpeed, double backLeftSpeed, double backRightSpeed){
        frontLeft.set(ControlMode.PercentOutput, frontLeftSpeed * maxSpeed);
        frontRight.set(ControlMode.PercentOutput, frontRightSpeed * maxSpeed);
        backLeft.set(ControlMode.PercentOutput, backLeftSpeed * maxSpeed);
        backRight.set(ControlMode.PercentOutput, backRightSpeed * maxSpeed);
    }
}