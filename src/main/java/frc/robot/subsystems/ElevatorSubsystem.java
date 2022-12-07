package frc.robot.subsystems;

import java.lang.invoke.ConstantBootstraps;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem  extends SubsystemBase{

    public WPI_VictorSPX motor;
    private final CANCoder encoder;

    private final PIDController pid;
    public WPI_VictorSPX motor2;
    private final CANCoder encoder2;
    private final PIDController pid2;

    public ElevatorSubsystem() {
        motor = new WPI_VictorSPX(Constants.ELEVATOR_MOTORRIGHT_ID);
        motor2 = new WPI_VictorSPX(Constants.ELEVATOR_MOTORLEFT_ID);


        motor.configFactoryDefault();
        motor2.configFactoryDefault();
        

        motor.setNeutralMode(NeutralMode.Brake);
        motor2.setNeutralMode(NeutralMode.Brake);

        encoder = new CANCoder(Constants.ELEVATOR_MOTORLEFT_ENCODER);
        encoder2 = new CANCoder(Constants.ELEVATOR_MOTORRIGHT_ENCODER);
        pid = new PIDController(0.01, 0, 0);
        pid2 = new PIDController(0.01, 0, 0);
    }

    public void setPosition(double position) {
        pid.setSetpoint(position);
        pid2.setSetpoint(-position);
    }

    //called continuously forever
    @Override
    public void periodic() {
        double voltage = pid.calculate(encoder.getPosition());
        double voltage2 = pid2.calculate(encoder2.getPosition());
        motor.set(voltage);
        motor2.set(voltage2);
    }
}
