// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.OI;
import frc.robot.Commands.ArmCommand;
import frc.robot.Commands.ElevatorCommand;
import frc.robot.Commands.IntakeCommand;
import frc.robot.Commands.OuttakeCommand;
import frc.robot.Subsystem.ArmSubsystem;
import frc.robot.Subsystem.ElevatorSubsystem;
import frc.robot.Subsystem.IntakeSubsystem;
import frc.robot.Constants;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final OI oi = new OI();
  private final ElevatorSubsystem elevator = new ElevatorSubsystem();
  private final ArmSubsystem arm = new ArmSubsystem();
  private final IntakeSubsystem intake= new IntakeSubsystem();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    elevator.setDefaultCommand(new ElevatorCommand(elevator,1.0));
    arm.setDefaultCommand(new ArmCommand(oi, arm));

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    oi.getButton(1, Constants.Buttons.X_BUTTON).whenHeld(new ElevatorCommand(elevator, 1.0));
    oi.getButton(2, Constants.Buttons.Y_BUTTON).whenHeld(new ElevatorCommand(elevator, 1.0));

    oi.getButton(2, Constants.Buttons.Y_BUTTON).whenHeld(new IntakeCommand(intake));
    oi.getButton(2, Constants.Buttons.Y_BUTTON).whenHeld(new OuttakeCommand(intake));


 
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
