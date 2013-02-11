package org.usfirst.frc3467.subsystems.drivebase;

import org.usfirst.frc3467.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shifters extends Subsystem {

	protected void initDefaultCommand() {
		//Do not set a default shifting state
	}

	public static Shifters instance = null;

	public static Shifters getInstance() {
		if (instance == null)
			instance = new Shifters();
		return instance;
	}

	Solenoid sole1 = new Solenoid(RobotMap.solenoidShiftDown);
	Solenoid sole2 = new Solenoid(RobotMap.solenoidShiftUp);

	public void shiftUp() {
		sole1.set(false);
		sole2.set(true);
	}

	public void shiftDown() {
		sole1.set(true);
		sole2.set(false);
	}

	public void shiftOff() {
		sole1.set(false);
		sole2.set(false);
	}
}
