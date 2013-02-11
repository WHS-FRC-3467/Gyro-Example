package org.usfirst.frc3467.subsystems.shooter;

import org.usfirst.frc3467.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Loader extends Subsystem {

	protected void initDefaultCommand() {
		//Do not set a default shifting state
	}

	public static Loader instance = null;

	public static Loader getInstance() {
		if (instance == null)
			instance = new Loader();
		return instance;
	}

	Solenoid sole1 = new Solenoid(RobotMap.solenoidLoadIn);
	Solenoid sole2 = new Solenoid(RobotMap.solenoidLoadOut);

	public void loadOut() {
		sole1.set(false);
		sole2.set(true);
	}

	public void loadIn() {
		sole1.set(true);
		sole2.set(false);
	}

	public void loadOff() {
		sole1.set(false);
		sole2.set(false);
	}
}
