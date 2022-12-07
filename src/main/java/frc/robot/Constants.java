// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final double DEADZONE_VALUE = 0.01;
	public static final int NUMBER_OF_CONTROLLERS = 2;

	public static final int TURRET_MOTOR_ID = 1;
	public static final int LEFT_CLIMBER_MOTOR_ID = 2;
	public static final int RIGHT_CLIMBER_MOTOR_ID = 3;

	public static final int INTAKE_MOTOR_ID = 4;
	public static final int FEEDER_MOTOR_ID = 5;

	public static final int JUMP_MOTOR_ID = 6;

	public static final int CLIMBER_SOLENOID_CHANNEL = 1;
	public static final int INTAKE_SOLENOID_CHANNEL = 2;
	
	public static final int JUMP_SOLENOID_CHANNEL = 3;

	public static final double RIGHT_CLIMBER_SPEED_CORRECTION = 0.75;
    public static final int ELEVATOR_MOTOR_ID = 0;
    public static final int ELEVATOR_ENCODER = 0;

    public enum Axes {
		LEFT_STICK_X(0), LEFT_STICK_Y(4), LEFT_TRIGGER(2), RIGHT_TRIGGER(3), RIGHT_STICK_X(1), RIGHT_STICK_Y(5);

		private final int value;

		Axes(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	public enum Buttons {
		A_BUTTON(1), B_BUTTON(2), X_BUTTON(3), Y_BUTTON(4), LEFT_BUMPER(5), RIGHT_BUMPER(6), BACK_BUTTON(
				7), START_BUTTON(8), LEFT_STICK(9), RIGHT_STICK(10);

		private final int value;

		private Buttons(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

	}   
}
