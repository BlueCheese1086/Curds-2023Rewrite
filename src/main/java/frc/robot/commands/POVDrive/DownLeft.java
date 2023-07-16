// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.POVDrive;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Drivetrain;

public class DownLeft extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final Drivetrain drivetrain;

    /**
     * Creates a new DownLeft command.
     *
     * @param subsystem The subsystem used by this command.
     */
    public DownLeft(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled. (Approx 20 ms.)
    @Override
    public void execute() {
        PIDController zero = new PIDController(1.02, 0.02, 0);
        double zeroed = zero.calculate(0);
        drivetrain.setSpeeds(-1, -zeroed, -zeroed, -1);
        zero.close();
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