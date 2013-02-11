package org.usfirst.frc3467.subsystems;

import org.usfirst.frc3467.commands.CommandBase;

import edu.wpi.first.wpilibj.Accelerometer;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class AccelSub extends PIDSubsystem {

	public static double Kp = 0.01;
	public static double Ki = 0.00;
	public static double Kd = 0.001;
	
	Accelerometer accel;

	public AccelSub() {
		super("AccelSub", Kp, Ki, Kd);
		accel = new Accelerometer(1);
		accel.setZero(0);

		setSetpoint(0);
		enable();
	}

	protected double returnPIDInput() {
		double a = accel.pidGet();
		DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser5, 1, "Accel: " + a);
		return a;
	}

	protected void usePIDOutput(double output) {
		CommandBase.driveBase.direction = output;
	}

	protected void initDefaultCommand() {
		
	}

}
