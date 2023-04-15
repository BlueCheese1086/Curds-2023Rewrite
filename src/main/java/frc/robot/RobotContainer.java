// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.commands.POVDrive.*;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain drivetrain = new Drivetrain();

  // Xbox Remote
  private final XboxController xboxController = new XboxController(0);

  // Joystick Remote
  private final Joystick joystick = new Joystick(2);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    drivetrain.setDefaultCommand(joystickArcadeDrive()); 

    // Adds d-pad controls.
    /*
      new POVButton(xboxController, 0).onTrue(new Up(drivetrain));           // Up
      new POVButton(xboxController, 45).onTrue(new UpRight(drivetrain));     // Up-Right
      new POVButton(xboxController, 90).onTrue(new Right(drivetrain));       // Right
      new POVButton(xboxController, 135).onTrue(new DownRight(drivetrain));  // Down-Right
      new POVButton(xboxController, 180).onTrue(new Down(drivetrain));       // Down
      new POVButton(xboxController, 225).onTrue(new DownLeft(drivetrain));   // Down-Left
      new POVButton(xboxController, 270).onTrue(new Left(drivetrain));       // Left
      new POVButton(xboxController, 315).onTrue(new UpLeft(drivetrain));     // Up-Left
    */

    new POVButton(joystick, 45).whileTrue(new UpRight(drivetrain));          // Up-Right
    new POVButton(joystick, 135).whileTrue(new DownRight(drivetrain));       // Down-Right
    new POVButton(joystick, 225).whileTrue(new DownLeft(drivetrain));        // Down-Left
    new POVButton(joystick, 315).whileTrue(new UpLeft(drivetrain));          // Up-Left
    new POVButton(joystick, 0).whileTrue(new Up(drivetrain));                // Up
    new POVButton(joystick, 90).whileTrue(new Right(drivetrain));            // Right
    new POVButton(joystick, 180).whileTrue(new Down(drivetrain));            // Down
    new POVButton(joystick, 270).whileTrue(new Left(drivetrain));            // Left
  }

  /**
   * Use this to pass the ArcadeDrive command to the main {@link Robot} class.
   * Input type: XboxController
   * 
   * @return the command to run in teleop
   */
  public Command xboxArcadeDrive() {
    // An example command will be run in autonomous
    return new ArcadeDrive(drivetrain, () -> xboxController.getLeftY(), () -> xboxController.getRightX(), Constants.squareInputs);
  }

  /**
   * Use this to pass the ArcadeDrive command to the main {@link Robot} class.
   * Input type: Joytstick
   * 
   * @return the command to run in autonomous
   */
  public Command joystickArcadeDrive() {
    // An example command will be run in autonomous
    return new ArcadeDrive(drivetrain, () -> -joystick.getRawAxis(1), () -> joystick.getRawAxis(4), Constants.squareInputs);
  }
}
