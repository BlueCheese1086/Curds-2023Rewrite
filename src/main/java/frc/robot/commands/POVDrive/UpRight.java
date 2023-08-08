package frc.robot.Commands.POVDrive;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Drivetrain;

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

    @Override
    // This run repeatedly while the command is scheduled.  It tells the program when the command should end.
    public boolean isFinished() {
        return false;
    }
}