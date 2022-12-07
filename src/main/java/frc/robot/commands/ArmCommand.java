package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.Constants;

public class ArmCommand extends CommandBase {
    private final ArmSubsystem armSubsystem;
    private final OI oi;

    public ArmCommand(ArmSubsystem a, OI oily) {
        this.armSubsystem = a;
        this.oi = oily;
        addRequirements(a);
    }
    
    @Override
    public void initialize() {
    }
    
    @Override
    public void execute() {
        double val1 = oi.getAxis(0, Constants.Axes.LEFT_STICK_Y);
        double val2 = oi.getAxis(0, Constants.Axes.RIGHT_STICK_Y);
        armSubsystem.setArmAngle(val1);
        armSubsystem.setLowerArmAngle(val2);
    }
    @Override
    public void end(boolean interrupted) {}
    
    @Override
    public boolean isFinished() {
        return false;
    }

    
}
