package org.usfirst.frc3467.subsystems;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.commands.Turn;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class GyroSub extends PIDSubsystem {

	public static double Kp = 0.05;
	public static double Ki = 0.007;
	public static double Kd = 0.09;
	
	public Gyro gyro = new Gyro(2);

	public GyroSub() {
		super("GyroSub", Kp, Ki, Kd);
		gyro.reset();
		setSetpoint(gyro.pidGet());
		enable();
	}

	public double returnPIDInput() {
		double angle = gyro.pidGet();
		if (angle > 360 || angle < -360 || (Math.abs(getSetpoint() - angle) > 180))
			gyro.reset();
		DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 1, "Current angle: " + angle);
		return angle;
	}

	protected void usePIDOutput(double output) {
		if (output > 1.0)
			output = 1.0;
		if (output < -1.0)
			output = -1.0;
		CommandBase.driveBase.turn = output;
	}

	protected void initDefaultCommand() {
		this.setDefaultCommand(new Turn());
	}
}
