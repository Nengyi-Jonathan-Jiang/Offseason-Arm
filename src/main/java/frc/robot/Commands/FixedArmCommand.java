package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;
import frc.robot.Subsystem.ArmSubsystem;
import frc.robot.Constants;
//takes in two more parameters and takes set points
public class FixedArmCommand extends CommandBase{
    private final ArmSubsystem sub;

    public FixedArmCommand( ArmSubsystem sub) {
        this.sub = sub;
        addRequirements(sub);
    }

    @Override
    public void initialize() {
        sub.stop();
    }

    @Override
    public void execute() {
        sub.setArmPoint(1);
        sub.setWristPoint(1);
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
