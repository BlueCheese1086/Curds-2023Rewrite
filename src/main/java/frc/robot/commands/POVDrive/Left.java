package frc.robot.Commands.POVDrive;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Drivetrain;

public class Left extends CommandBase {
    private Drivetrain drivetrain;

    public Left(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    @Override
    // This run repeatedly while the command is scheduled.
    public void execute() {
        drivetrain.drive(-1, 1, 1, -1);
    }

    // This run repeatedly while the command is scheduled.  It tells the program when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}