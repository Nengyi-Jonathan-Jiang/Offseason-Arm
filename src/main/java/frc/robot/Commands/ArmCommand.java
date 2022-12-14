package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;
import frc.robot.Subsystem.ArmSubsystem;
import frc.robot.Constants;
//takes in two more parameters and takes set points
public class ArmCommand extends CommandBase{
    private final ArmSubsystem sub;
    private final OI oi;

    public ArmCommand(OI oi, ArmSubsystem sub) {
        this.sub = sub;
        this.oi = oi;
        addRequirements(sub);
    }

    @Override
    public void initialize() {
        sub.stop();
    }

    @Override
    public void execute() {
        double armPos = oi.getAxis(0, Constants.Axes.LEFT_STICK_Y);
        double wristPos = oi.getAxis(0, Constants.Axes.RIGHT_STICK_Y);
        sub.setArmPoint(armPos);
        sub.setWristPoint(wristPos);
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
