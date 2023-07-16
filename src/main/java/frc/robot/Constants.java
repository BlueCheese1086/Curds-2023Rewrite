// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * Contains variables that are constant throughout the program.
 * 
 * <p>Also contains the values that are meant to be edited for demos.
 */
public final class Constants {
    public static final boolean squareInputs = false; // If true, this will square the motor speeds to make for faster acceleration.
    public static final double deadband = 0.02; // If the absolute value of the joystick inputs are below this number, the robot will not move.

    // Edit these values depending on the way you want the program to be set up.
    public static final boolean usingXboxRemote = false; // Change to "true" if using an xbox remote.  Make it "false" otherwise.
    public static final int joystickPort = 100; // Change to the green number seen in the fourth tab on the left in FRC Driverstation.
    public static final int RightX = 0; // In FRC Driverstation, click the green label.  Move the right joystick left to right, and see what number moves.  Then, look at the label, and put the number you see there here.
    public static final int LeftY = 0; // In FRC Driverstation, click the green label.  Move the left joystick up and down, and see what number moves.  Then, look at the label, and put the number you see there here.
    public static final double maxSpeed = 0.25; // This sets the max speed of the motors.  A good value for this is 0.25, aka a quarter of the robot's max speed.
}