package frc.robot.Subsystem;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.fasterxml.jackson.databind.jsontype.impl.SubTypeValidator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
    private final WPI_VictorSPX motor;
    
    public IntakeSubsystem() {
        motor = new WPI_VictorSPX(Constants.INTAKE_MOTOR_ID);
        motor.configFactoryDefault();
        motor.setNeutralMode(NeutralMode.Coast);
    }

    public void intake(double speed) {
        motor.set(speed);
    }

    public void stop() {
        motor.stopMotor();
    }
}


