package frc.robot.Subsystems.Drivetrain.Commands.POVDrive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Drivetrain.Drivetrain;

public class Up extends CommandBase {
    private Drivetrain drivetrain;

    public Up(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    @Override
    // This run repeatedly while the command is scheduled.
    public void execute() {
        drivetrain.drive(1, 1, 1, 1);
    }
}