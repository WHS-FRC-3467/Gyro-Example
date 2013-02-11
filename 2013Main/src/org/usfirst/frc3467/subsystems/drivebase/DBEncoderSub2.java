package org.usfirst.frc3467.subsystems.drivebase;

import org.usfirst.frc3467.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DBEncoderSub2 extends PIDSubsystem {
	public static DBEncoderSub2 instance = null;

	public static DBEncoderSub2 getInstance() {
		if (instance == null)
			instance = new DBEncoderSub2();
		return instance;
	}
	
	public double output = 0.0;

	public static double Kp = RobotMap.encoderKp;
	public static double Ki = RobotMap.encoderKi;
	public static double Kd = RobotMap.encoderKd;

	private Encoder rightEnc = new Encoder(RobotMap.rightSigA, RobotMap.rightSigB);

	public DBEncoderSub2() {
		super("DBEncoderSub", Kp, Ki, Kd);
		rightEnc.reset();
		setSetpoint(0);
		enable();
	}

	public double returnPIDInput() {
		return rightEnc.pidGet();
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
