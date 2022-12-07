package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.DriveTrainSubsystem;

public class SwerveDriveCommand extends CommandBase{
    private final OI oi;
    private final DriveTrainSubsystem drive;

    // dont do it like this
    public SwerveDriveCommand(DriveTrainSubsystem driveTrainSubsystem, OI oi){
        this.oi = oi;
        this.drive = driveTrainSubsystem;

        addRequirements(driveTrainSubsystem);
    }

    @Override
    public void initialize() {
        drive.stop();
    }

    @Override
    public void execute() {
        // joystick x, joystick y
        double rawX = oi.getAxis(0, Constants.Axes.LEFT_STICK_X), rawY = oi.getAxis(0, Constants.Axes.LEFT_STICK_Y);
        // stuff

        double angle = Math.atan2(rawY, rawX);
        double speed = Math.sqrt(rawX * rawX + rawY * rawY);

        drive.setAllModules(angle, speed);
    }

    @Override
    public void end(boolean interrupted) {
        drive.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}