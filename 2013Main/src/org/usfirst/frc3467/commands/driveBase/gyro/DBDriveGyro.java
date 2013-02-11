package org.usfirst.frc3467.commands.driveBase.gyro;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.drivebase.DriveBase;
import org.usfirst.frc3467.subsystems.drivebase.DBGyroSub;

public class DBDriveGyro extends CommandBase {
	DriveBase db;

	public DBDriveGyro() {
		db = DriveBase.getInstance();
		requires(db);
		// Makes this command interrupt another
		// command using the same subsystem
	}

	protected void initialize() {

	}

	protected void execute() {
		double output = DBGyroSub.getInstance().gyroPIDOutput; // Get gyroPIDOutput
		db.drive(output, -output); // Apply values to drive base
	}
	
	protected void interrupted() {

	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

}
