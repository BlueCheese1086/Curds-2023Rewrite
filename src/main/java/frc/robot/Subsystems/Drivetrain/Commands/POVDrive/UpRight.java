package frc.robot.Subsystems.Drivetrain.Commands.POVDrive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Drivetrain.Drivetrain;

public class UpRight extends CommandBase {
    private Drivetrain drivetrain;

    public UpRight(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    @Override
    // This runs repeatedly while the command is scheduled.
    public void execute() {
        drivetrain.drive(1, 0, 0, 1);
    }
}