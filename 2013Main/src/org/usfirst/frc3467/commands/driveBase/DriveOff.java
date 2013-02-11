package org.usfirst.frc3467.commands.driveBase;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.drivebase.DriveBase;

public class DriveOff extends CommandBase {
	DriveBase db;

	public DriveOff() {
		db = DriveBase.getInstance();
		requires(db);
		// Makes this command interrupt another
		// command using the same subsystem
	}

	protected void initialize() {

	}

	protected void execute() {
		db.drive(0, 0);
		// Set motors to 0 to prevent it from running away
	}

	protected void interrupted() {

	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

}
