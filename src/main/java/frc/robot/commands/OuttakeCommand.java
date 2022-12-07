package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class OuttakeCommand extends CommandBase{
    
    private final IntakeSubsystem outtakeSubsystem;

    public OuttakeCommand(IntakeSubsystem outtakeSubsystem) {
        this.outtakeSubsystem = outtakeSubsystem;

        addRequirements(outtakeSubsystem);
    }

    @Override
    public void initialize() {
        outtakeSubsystem.stop();
    }
    @Override
    public void execute(){
        outtakeSubsystem.intake(-1);
    }
    @Override
    public void end(boolean interrupted) {
        outtakeSubsystem.stop();
    }
    @Override

    public boolean isFinished(){
        return false;
    }

}
