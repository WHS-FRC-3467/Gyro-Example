package org.usfirst.frc3467.subsystems.drivebase;

import org.usfirst.frc3467.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DBGyroSub extends PIDSubsystem {
	
	public static DBGyroSub instance = null;

	public static DBGyroSub getInstance() {
		if (instance == null)
			instance = new DBGyroSub();
		return instance;
	}

	public double gyroPIDOutput = 0.0;

	private static double Kp = RobotMap.gyroKp;
	private static double Ki = RobotMap.gyroKi;
	private static double Kd = RobotMap.gyroKd;

	private Gyro gyro = new Gyro(RobotMap.gyroAnalogPort);

	public DBGyroSub() {
		super("GyroSub", Kp, Ki, Kd);
		setSetpoint(0);
		gyro.reset();
		enable();
	}

	public double returnPIDInput() {
		double angle = gyro.pidGet();
		if (angle > 360 || angle < -360) {
			gyro.reset();
		}
		if (Math.abs(getSetpoint() - angle) > 180) {
			angle = -(360 - Math.abs(angle));
		}
		return angle;
	}

	protected void usePIDOutput(double output) {
		if (output > 1.0)
			output = 1.0;
		if (output < -1.0)
			output = -1.0;
		gyroPIDOutput = output;
	}

	protected void initDefaultCommand() {

	}
}
