package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.Constants;

public class ArmCommand extends CommandBase{
    private final ArmSubsystem a;
    private final OI oily;

    public ArmCommand(ArmSubsystem a, OI oily) {
        this.a = a;
        this.oily = oily;
        addRequirements(a);
    }
    public void initialize() {
        a.stop();
    }
    public void execute() {
        double val1 = oily.getAxis(0, Constants.Axes.LEFT_STICK_X);
        double val2 = oily.getAxis(0, Constants.Axes.LEFT_STICK_Y);
        a.setArmAngle(val1);
        a.setLowerArmAngle(val2);
    }
    public void end() {
        a.stop();
    }
    public boolean isFinished() {
        return false;
    }

    
}
