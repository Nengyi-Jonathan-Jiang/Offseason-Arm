package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.OI;
import frc.robot.Subsystem.IntakeSubsystem;
import frc.robot.Constants;
public class OuttakeCommand extends CommandBase {
    
    private final IntakeSubsystem sub;

    public OuttakeCommand(IntakeSubsystem sub) {
        this.sub = sub;
    }

    @Override
    public void initialize() {
        sub.stop();
    }

    @Override
    public void execute() {
        
        sub.intake(-1);
    }
    
    @Override
    public void end(boolean interrupted) {
        sub.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
