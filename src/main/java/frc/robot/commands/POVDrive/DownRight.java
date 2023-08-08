package frc.robot.Commands.POVDrive;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Drivetrain;

public class DownRight extends CommandBase {
    private Drivetrain drivetrain;

    public DownRight(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    @Override
    // This run repeatedly while the command is scheduled.
    public void execute() {
        drivetrain.drive(0, -1, -1, 0);
    }

    @Override
    // This run repeatedly while the command is scheduled.  It tells the program when the command should end.
    public boolean isFinished() {
        return false;
    }
}