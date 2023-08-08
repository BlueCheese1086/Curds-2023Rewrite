package frc.robot.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Drivetrain;

public class ArcadeDrive extends CommandBase {
    private Drivetrain drivetrain;
    private Supplier<Double> xSpeed;
    private Supplier<Double> zRotation;

    public ArcadeDrive(Drivetrain drivetrain, Supplier<Double> xSpeedSupplier, Supplier<Double> zRotationSupplier) {
        this.drivetrain = drivetrain;
        this.xSpeed = xSpeedSupplier;
        this.zRotation = zRotationSupplier;
    }

    @Override
    // This run repeatedly while the command is scheduled.
    public void execute() {
        drivetrain.arcadeDrive(xSpeed.get(), zRotation.get());
    }
    
    @Override
    // This run repeatedly while the command is scheduled.  It tells the program when the command should end.
    public boolean isFinished() {
        return false;
    }
}