package org.usfirst.frc3467.commands.pid;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.GyroSub;

public class Pdec extends CommandBase {

	protected void initialize() {
		GyroSub.Kp -= 0.01;
	}

	protected void execute() {
		// TODO Auto-generated method stub

	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub

	}

	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
