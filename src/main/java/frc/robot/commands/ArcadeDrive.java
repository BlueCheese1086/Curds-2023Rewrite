// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Drivetrain;

import java.util.function.Supplier;

public class ArcadeDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain drivetrain;
  private final Supplier<Double> xAxisSpeed;
  private final Supplier<Double> zAxisRotate;

  /**
   * Creates a new ArcadeDrive command.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ArcadeDrive(Drivetrain drivetrain, Supplier<Double> xAxisSpeed, Supplier<Double> zAxisRotate) {
    this.drivetrain = drivetrain;
    this.xAxisSpeed = xAxisSpeed;
    this.zAxisRotate = zAxisRotate;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled. (Approx 20 ms.)
  @Override
  public void execute() {
    drivetrain.arcadeDrive(xAxisSpeed.get(), zAxisRotate.get());
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}
}