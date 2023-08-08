package frc.robot.Commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.Commands.Autonomous.MecanumTime.Directions;
import frc.robot.Drivetrain;

// Due to a suspicious lack of encoders on NSP, these commands will be based off of time, and not distance.
public class Autonomous extends SequentialCommandGroup {
    public Autonomous(Drivetrain drivetrain) {
        addCommands(
            new DriveTime(1, 1, drivetrain),
            new TurnTime(1, 1, drivetrain),
            new MecanumTime(1, Directions.DOWN, 1, drivetrain)
        );
    }
}