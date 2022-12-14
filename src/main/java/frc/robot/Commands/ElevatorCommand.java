package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.Subsystem.ElevatorSubsystem;

public class ElevatorCommand extends CommandBase{
    private final ElevatorSubsystem elevator;
    private final double position;
    public ElevatorCommand(ElevatorSubsystem elevator, double p){
        this.elevator = elevator;
        position = p;
        addRequirements(elevator);
    }
    public void execute(){
       elevator.setPosition(position);
    }
    public void initialize(){
    }
    public void stop(){
    }
    public boolean isFinished(){
        return false;
    }

}
