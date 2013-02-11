package org.usfirst.frc3467.commands.driveBase;

import org.usfirst.frc3467.OI;
import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.drivebase.DriveBase;

public class DriveGamepad extends CommandBase {
	DriveBase db;

	public DriveGamepad() {
		db = DriveBase.getInstance();
		requires(db);
		// Makes this command interrupt another
		// command using the same subsystem
	}

	protected void initialize() {

	}

	protected void execute() {
		double left = 0.0;
		double right = 0.0;
		// Create left and right and set zero to
		// prevent null from being fed into the drive base
		left = -OI.gamepad.getLeftStickY();
		right = -OI.gamepad.getRightStickY();
		// Set left and right = the Y axis of the gamepad
		db.drive(left, right);
		// Apply values to motor
	}

	protected void interrupted() {

	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

}
