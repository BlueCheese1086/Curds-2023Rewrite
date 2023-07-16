// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.POVDrive.*;
import frc.robot.subsystems.Drivetrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystem is defined here.  Curds is very simple, what can I say?
  private final Drivetrain drivetrain = new Drivetrain();

  // Configures controllers
  private final Joystick joystick = new Joystick(Constants.joystickPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Sets up the button bindings.
    configureBindings();
  }

  /** Use this method to define your trigger mappings. */
  private void configureBindings() {
    // Adds d-pad controls to the joystick.
    new POVButton(joystick, 0).whileTrue(new Up(drivetrain));
    new POVButton(joystick, 45).whileTrue(new UpRight(drivetrain));
    new POVButton(joystick, 90).whileTrue(new Right(drivetrain));
    new POVButton(joystick, 135).whileTrue(new DownRight(drivetrain));
    new POVButton(joystick, 180).whileTrue(new Down(drivetrain));
    new POVButton(joystick, 225).whileTrue(new DownLeft(drivetrain));
    new POVButton(joystick, 270).whileTrue(new Left(drivetrain));
    new POVButton(joystick, 315).whileTrue(new UpLeft(drivetrain));
  }

  /**
   * Use this to pass the Teleop command to the {@link Robot} class.
   * 
   * @return the command to run in teleop
   */
  public Command getTeleopCommand() {
    // An example command will be run in autonomous
    return new ArcadeDrive(drivetrain, () -> -joystick.getRawAxis(Constants.LeftY), () -> joystick.getRawAxis(Constants.RightX));
  }
}