package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;

public class ArmSubsystem extends SubsystemBase{
    private final WPI_VictorSPX armMotor;
    private final WPI_VictorSPX armMotor2;
    private final PIDController pid;
    private final PIDController pid2;
    private final CANCoder encoder;
    private final CANCoder encoder2;
    private double voltage;
    private double voltage2;

    public ArmSubsystem() {
        armMotor = new WPI_VictorSPX(0);
        armMotor2 = new WPI_VictorSPX(1);
        armMotor.configFactoryDefault();
        armMotor2.configFactoryDefault();
        armMotor.setNeutralMode(NeutralMode.Brake);
        armMotor2.setNeutralMode(NeutralMode.Brake);
        pid = new PIDController(0, 0, 0);
        pid2 = new PIDController(0,0,0);
        encoder = new CANCoder(2);
        encoder2 = new CANCoder(3);
        
    }
    @Override
    public void periodic() {
        double rawAngle = encoder.getPosition();
        double rawAngle2 = encoder2.getPosition();
        double angle = (rawAngle % (2*Math.PI) + (2*Math.PI))%(2*Math.PI);
        double angle2 = (rawAngle2 % (2*Math.PI) + (2*Math.PI))%(2*Math.PI);
        voltage = pid.calculate(angle);
        voltage2 = pid.calculate(angle2);
        armMotor.set(voltage);
        armMotor2.set(voltage2);

    }
    public void setArmAngle(double angle) {
        pid.setSetpoint(angle);
    }
    public void setLowerArmAngle(double angle) {
        pid2.setSetpoint(angle);
    }
    public void stop() {
        pid.setSetpoint(pid.calculate(voltage));
        pid2.setSetpoint(pid2.calculate(voltage2));
        //armMotor.stopMotor();
        //armMotor2.stopMotor();
    }

    
    
}
