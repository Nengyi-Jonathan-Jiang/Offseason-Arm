package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    private WPI_VictorSPX intakeMotor;
    
    public IntakeSubsystem(){
        intakeMotor = new WPI_VictorSPX(4);
        intakeMotor.configFactoryDefault();
        intakeMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void intake(double speed) {
        intakeMotor.set(speed);
    }

    public void stop() {
        intakeMotor.set(0);
    }
}
