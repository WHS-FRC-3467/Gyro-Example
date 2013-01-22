package org.usfirst.frc3467.subsystems;

import org.usfirst.frc3467.OI;
import org.usfirst.frc3467.commands.Drive;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveBase extends PIDSubsystem {

	public static double Kp = 0.05;
	public static double Ki = 0.007;
	public static double Kd = 0.09;

	public Gyro gyro = new Gyro(2);
	private RobotDrive drive;
	CANJaguar jag1;
	CANJaguar jag2;
	CANJaguar jag3;
	CANJaguar jag4;

	public DriveBase() {
		super("DriveBase", Kp, Ki, Kd);
		gyro.reset();
		try {
			jag1 = new CANJaguar(2);
			jag2 = new CANJaguar(3);
			jag3 = new CANJaguar(4);
			jag4 = new CANJaguar(5);
		} catch (CANTimeoutException e) {

		}
		drive = new RobotDrive(jag1, jag2, jag3, jag4);
		drive.setSafetyEnabled(false);
		
		SmartDashboard.putDouble("P", Kp);
		SmartDashboard.putDouble("I", Ki);
		SmartDashboard.putDouble("D", Kd);

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
		DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser4, 1, "Motor output: " + output);
		double stick = OI.gamepad.getLeftStickY();
		double left = output + stick;
		double right = -output + stick;
		drive.tankDrive(left, right);
		DriverStationLCD.getInstance().updateLCD();
	}

	protected void initDefaultCommand() {
		this.setDefaultCommand(new Drive());
	}

}
