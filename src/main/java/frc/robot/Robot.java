// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static RobotContainer robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will set all our button bindings.
    robotContainer = new RobotContainer();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after mode specific periodic functions, but before LiveWindow and SmartDashboard update.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during the Disabled mode. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once each time the robot enters Autonomous mode. */
  @Override
  public void autonomousInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during the Autonomous mode. */
  @Override
  public void autonomousPeriodic() {}

  /** This function is called once each time the robot enters Teleop mode. */
  @Override
  public void teleopInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during the Teleop mode. */
  @Override
  public void teleopPeriodic() {
    robotContainer.getTeleopCommand().schedule();
  }

  /** This function is called once each time the robot enters Test mode. */
  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during the Test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once each time the robot enters Simulation mode. */
  @Override
  public void simulationInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during the Simulation mode. */
  @Override
  public void simulationPeriodic() {}
}