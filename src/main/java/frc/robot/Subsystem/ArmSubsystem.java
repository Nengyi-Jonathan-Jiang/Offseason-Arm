package frc.robot.Subsystem;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase{
    private final WPI_VictorSPX arm;
    private final WPI_VictorSPX wrist;
    private final PIDController armPid;
    private final CANCoder armCoder;
    private final PIDController wristPid;
    private final CANCoder wristCoder;

    public ArmSubsystem() { 
        armCoder = new CANCoder(Constants.ARM_MOTOR_ENCODER);
        armPid = new PIDController(0,0,0);
        wristCoder = new CANCoder(Constants.WRIST_MOTOR_ENCODER);
        wristPid = new PIDController(0,0,0);
        arm = new WPI_VictorSPX(Constants.ARM_MOTOR_ID);
        wrist = new WPI_VictorSPX(Constants.WRIST_MOTOR_ID);
        arm.configFactoryDefault();
        wrist.configFactoryDefault();
        arm.setNeutralMode(NeutralMode.Coast);
        wrist.setNeutralMode(NeutralMode.Coast);
    }

    public void setArmPoint (double setPoint) {
        armPid.setSetpoint(setPoint);
    }
    public void setWristPoint(double setPoint) {
        wristPid.setSetpoint(setPoint);
    }

    @Override
    public void periodic() {
        double armVoltage = armPid.calculate(armCoder.getPosition());
        double wristVoltage = wristPid.calculate(wristCoder.getPosition());
        arm.set(armVoltage);
        wrist.set(wristVoltage);
    }

    public void stop() {
        arm.stopMotor();
        wrist.stopMotor();
    }





}
