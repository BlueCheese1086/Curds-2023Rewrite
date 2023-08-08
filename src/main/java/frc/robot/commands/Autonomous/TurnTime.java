package frc.robot.Commands.Autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Drivetrain;

public class TurnTime extends CommandBase {
    private double speed;
    private double start;
    private double end;
    private Drivetrain drivetrain;

    public TurnTime(double speed, double seconds, Drivetrain drivetrain) {
        this.speed = speed;
        this.start = System.currentTimeMillis();
        this.end = start + (seconds * 1000);
        this.drivetrain = drivetrain;
    }

    @Override
    // This runs repeatedly while the command is scheduled.
    public void execute() {
        drivetrain.arcadeDrive(0, speed);
    }

    @Override
    // This runs once when the command ends.
    public void end(boolean interrupted) {
        drivetrain.arcadeDrive(0, 0);
    }

    @Override
    // This runs repeatedly while the command is scheduled.  It tells the program when the command should end.
    public boolean isFinished() {
        return (start == end);
    }
}