package frc.robot.Subsystems.Drivetrain.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Drivetrain.Drivetrain;

public class ArcadeDrive extends CommandBase {
    private Drivetrain drivetrain;
    private Supplier<Double> xSpeedSupplier;
    private Supplier<Double> zRotationSupplier;

    public ArcadeDrive(Drivetrain drivetrain, Supplier<Double> xSpeedSupplier, Supplier<Double> zRotationSupplier) {
        this.drivetrain = drivetrain;
        this.xSpeedSupplier = xSpeedSupplier;
        this.zRotationSupplier = zRotationSupplier;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        drivetrain.arcadeDrive(xSpeedSupplier.get(), zRotationSupplier.get());
    }
}