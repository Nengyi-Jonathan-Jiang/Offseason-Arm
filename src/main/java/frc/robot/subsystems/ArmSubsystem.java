package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
    private final WPI_VictorSPX armMotor;
    private final WPI_VictorSPX wristMotor;
    private final PIDController armPID;
    private final PIDController wristPID;
    private final CANCoder armEncoder;
    private final CANCoder wristEncoder;

    public ArmSubsystem() {
        armMotor = new WPI_VictorSPX(Constants.ARM_MOTOR_ID);
        wristMotor = new WPI_VictorSPX(Constants.WRIST_MOTOR_ID);
        armMotor.configFactoryDefault();
        wristMotor.configFactoryDefault();
        armMotor.setNeutralMode(NeutralMode.Brake);
        wristMotor.setNeutralMode(NeutralMode.Brake);
        armPID = new PIDController(0, 0, 0);
        wristPID = new PIDController(0,0,0);
        armEncoder = new CANCoder(Constants.INTAKE_MOTOR_ID);
        wristEncoder = new CANCoder(Constants.WRIST_MOTOR_ENCODER);
        
    }
    @Override
    public void periodic() {
        double rawAngle = armEncoder.getPosition();
        double rawAngle2 = wristEncoder.getPosition();
        double angle = rawAngle;
        double angle2 = rawAngle2;
        double voltage = armPID.calculate(angle);
        double voltage2 = armPID.calculate(angle2);
        armMotor.set(voltage);
        wristMotor.set(voltage2);

    }
    public void setArmAngle(double angle) {
        armPID.setSetpoint(angle);
    }
    public void setLowerArmAngle(double angle) {
        wristPID.setSetpoint(angle);
    }
}
