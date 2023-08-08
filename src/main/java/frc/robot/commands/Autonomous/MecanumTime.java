package frc.robot.Commands.Autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Drivetrain;

public class MecanumTime extends CommandBase {
    public enum Directions { // This makes the process of selecting a direction for the robot to go easier.
        UP,
        UPRIGHT,
        RIGHT,
        DOWNRIGHT,
        DOWN,
        DOWNLEFT,
        LEFT,
        UPLEFT;
    }

    private double speed;
    private Directions direction;
    private double start;
    private double end;
    private Drivetrain drivetrain;

    public MecanumTime(double speed, Directions direction, double seconds, Drivetrain drivetrain) {
        this.speed = speed;
        this.direction = direction;
        this.start = System.currentTimeMillis();
        this.end = start + (seconds * 1000);
        this.drivetrain = drivetrain;
    }

    @Override
    // This runs repeatedly while the command is scheduled.
    public void execute() {
        switch(direction) {
            case UP:
                drivetrain.drive(speed, speed, speed, speed);
            case UPRIGHT:
                drivetrain.drive(speed, 0, 0, speed);
            case RIGHT:
                drivetrain.drive(speed, -speed, -speed, speed);
            case DOWNRIGHT:
                drivetrain.drive(0, -speed, -speed, 0);
            case DOWN:
                drivetrain.drive(-speed, -speed, -speed, -speed);
            case DOWNLEFT:
                drivetrain.drive(-speed, 0, 0, -speed);
            case LEFT:
                drivetrain.drive(-speed, speed, speed, -speed);
            case UPLEFT:
                drivetrain.drive(0, speed, speed, 0);
        }
    }

    @Override
    // This runs once when the command ends.
    public void end(boolean interrupted) {
        drivetrain.drive(0, 0, 0, 0);
    }

    @Override
    // This runs repeatedly while the command is scheduled.  It tells the program when the command should end.
    public boolean isFinished() {
        return (start == end);
    }
}