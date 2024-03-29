package frc.robot.Subsystems.Drivetrain.Commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Subsystems.Drivetrain.Drivetrain;
import frc.robot.Subsystems.Drivetrain.Commands.Autonomous.MecanumTime.Directions;

// Due to a suspicious lack of encoders on NSP, these commands will be based off of time, and not distance.
public class Autonomous extends SequentialCommandGroup {
    public Autonomous(Drivetrain drivetrain) {
        addCommands(
            new DriveTime(drivetrain, 1, 1),
            new TurnTime(drivetrain, 1, 1),
            new MecanumTime(drivetrain, 1, Directions.DOWN, 1)
        );
    }
}