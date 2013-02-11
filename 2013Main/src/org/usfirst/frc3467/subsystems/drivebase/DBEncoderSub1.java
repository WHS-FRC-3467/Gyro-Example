package org.usfirst.frc3467.subsystems.drivebase;

import org.usfirst.frc3467.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DBEncoderSub1 extends PIDSubsystem {
	public static DBEncoderSub1 instance = null;

	public static DBEncoderSub1 getInstance() {
		if (instance == null)
			instance = new DBEncoderSub1();
		return instance;
	}

	public double output = 0.0;
	
	public static double Kp = RobotMap.encoderKp;
	public static double Ki = RobotMap.encoderKi;
	public static double Kd = RobotMap.encoderKd;

	private Encoder leftEnc = new Encoder(RobotMap.leftSigA, RobotMap.leftSigB);

	public DBEncoderSub1() {
		super("DBEncoderSub", Kp, Ki, Kd);
		leftEnc.reset();
		setSetpoint(0);
		enable();
	}

	public double returnPIDInput() {
		return 0.0;
	}

	protected void usePIDOutput(double output) {
		if (output > 1.0)
			output = 1.0;
		if (output < -1.0)
			output = -1.0;
		this.output = output;
	}

	protected void initDefaultCommand() {

	}
}
