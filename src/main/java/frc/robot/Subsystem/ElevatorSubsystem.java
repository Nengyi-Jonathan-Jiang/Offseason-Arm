package frc.robot.Subsystem;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase{
    private final WPI_VictorSPX firstMotor;
    private final PIDController pid;
    private final CANCoder can; 
    public ElevatorSubsystem(){
        firstMotor = new WPI_VictorSPX(Constants.elevatorMotor1ID);
        pid = new PIDController(0, 0, 0);

        can = new CANCoder(Constants.elevatorcanID);
        firstMotor.configFactoryDefault();
        firstMotor.setNeutralMode(NeutralMode.Brake);

    }
    public void setPosition(double position){
        pid.setSetpoint(position);
     }
     public void periodic(){
        double voltage = pid.calculate(can.getPosition());
        firstMotor.set(voltage);
    }
}
