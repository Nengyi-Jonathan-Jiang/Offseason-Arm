package frc.robot.subsystems;

import java.util.concurrent.atomic.AtomicBoolean;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.sensors.CANCoder;

import org.opencv.core.Mat;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveModuleSubsystem extends SubsystemBase {
    private final WPI_VictorSPX rotationMotor;
    private final WPI_VictorSPX driveMotor;
    private final PIDController pidController;
    private final CANCoder encoder;

    private boolean shouldReverseSpeed;

    public SwerveModuleSubsystem(int rotationMotorID, int driveMotorID, int encoderID){
        rotationMotor = new WPI_VictorSPX(rotationMotorID);
        driveMotor = new WPI_VictorSPX(driveMotorID);
        pidController = new PIDController(Constants.SWERVE_KP, Constants.SWERVE_KI, 0);
        encoder = new CANCoder(encoderID);

        rotationMotor.configFactoryDefault();
        driveMotor.configFactoryDefault();
        rotationMotor.setNeutralMode(NeutralMode.Brake);
        driveMotor.setNeutralMode(NeutralMode.Brake);
    }

    @Override
    public void periodic() {
        double rawAngle = encoder.getPosition();
        double tau = 2 * Math.PI;
        double angle = (rawAngle % tau + tau) % tau;
        double voltage = pidController.calculate(angle);
        rotationMotor.set(voltage);
    }

    // You can set the speed of the wheel and the direction of the wheel

    // both params are guaranteed to be from 0 - 2 pi
    private double correctAngle(double targetAngle, double currentAngle){
        double correctedTargetAngle = targetAngle;
        boolean reverseSpeed = false;
        
        double a1 = targetAngle;
        double a2 = targetAngle - Math.PI;
        double a3 = targetAngle - Math.PI * 2;
        double a4 = targetAngle + Math.PI;
        double a5 = targetAngle + Math.PI * 2;

        double d1 = Math.abs(a1 - currentAngle);
        double d2 = Math.abs(a2 - currentAngle);
        double d3 = Math.abs(a3 - currentAngle);
        double d4 = Math.abs(a4 - currentAngle);
        double d5 = Math.abs(a5 - currentAngle);

        double min = Math.min(d1, Math.min(d2, Math.min(d3, Math.min(d4, d5))));

        if(min == d1){
            shouldReverseSpeed = false;
            correctedTargetAngle = a1;
        }
        else if(min == d2){
            shouldReverseSpeed = true;
            correctedTargetAngle = a2;
        }
        else if(min == d3){
            shouldReverseSpeed = false;
            correctedTargetAngle = a3;
        }
        else if(min == d4){
            shouldReverseSpeed = true;
            correctedTargetAngle = a4;
        }
        else if(min == d5){
            shouldReverseSpeed = false;
            correctedTargetAngle = a5;
        }

        shouldReverseSpeed = reverseSpeed;
        return correctedTargetAngle;
    }

    // 0 < angle < 2 pi (angle is in radians)
    public void setDirection(double angle){
        pidController.setSetpoint(correctAngle(angle, encoder.getPosition()));
    }

    // 0 < speed < 1
    public void setWheelSpeed(double speed){
        driveMotor.set(speed * (shouldReverseSpeed ? -1 : 1));
    }
}