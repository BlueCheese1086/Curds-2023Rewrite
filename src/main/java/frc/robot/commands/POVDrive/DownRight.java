// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.POVDrive;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An arcade drive command that uses a drivetrain. */
public class DownRight extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final Drivetrain drivetrain;

    /**
     * Creates a new POVDrive command.
     *
     * @param subsystem The subsystem used by this command.
     */
    public DownRight(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(drivetrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        PIDController zero = new PIDController(1.02, 0.02, 0);
        double zeroed = zero.calculate(0);
        drivetrain.povDrive(zeroed, 0.25, 0.25, zeroed);
        zero.close();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
