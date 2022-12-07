package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.Constants;

public class IntakeCommand extends CommandBase{
    
    private final IntakeSubsystem intakeSubsystem;

    public IntakeCommand(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;

        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {
        intakeSubsystem.stop();
    }
    @Override
    public void execute(){
        intakeSubsystem.intake(1);
    }
    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.stop();
    }
    @Override

    public boolean isFinished(){
        return false;
    }

}
