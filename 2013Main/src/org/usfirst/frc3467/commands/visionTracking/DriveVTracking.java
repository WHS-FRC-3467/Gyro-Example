package org.usfirst.frc3467.commands.visionTracking;

import org.usfirst.frc3467.CommandBasedRobot;
import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.VisionTracking;
import org.usfirst.frc3467.subsystems.drivebase.DriveBase;
import org.usfirst.frc3467.subsystems.drivebase.DBGyroSub;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveVTracking extends CommandBase {
	DriveBase db;
	double azimuth;

	public static boolean finished = false;

	public DriveVTracking() {
		db = DriveBase.getInstance();
		requires(db);
		// Makes this command interrupt another
		// command using the same subsystem
	}

	protected void initialize() {
		double setPoint = 0; // Create the enw setPoint
		// Get calculated azimuth
		azimuth = CommandBasedRobot.table.getNumber("azimuth");
		// If the azimuth is not the same as the last time
		if (azimuth != VisionTracking.cachedAzimuth) {
			// Cache the new azimuth
			VisionTracking.cachedAzimuth = azimuth;
			setPoint = DBGyroSub.getInstance().returnPIDInput() + azimuth;
			// Set the setPoint of the gyro
			DBGyroSub.getInstance().setSetpoint(setPoint);
		}
	}

	protected void execute() {
		double output = DBGyroSub.getInstance().gyroPIDOutput;
		db.drive(output, -output);
		//If the offset of the robot from the target is less the 2 degrees ignore it
		if (Math.abs(DBGyroSub.getInstance().getSetpoint() - DBGyroSub.getInstance().returnPIDInput()) < 2) 
			SmartDashboard.putString("Alignment: ", "Finished");
		else
			SmartDashboard.putString("Alignment: ", "NOT DONE");
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {

	}

}
