package org.usfirst.frc3467.commands;

import org.usfirst.frc3467.OI;
import org.usfirst.frc3467.subsystems.GyroSub;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.DriverStationLCD.Line;

public class Turn extends CommandBase {
	GyroSub db;
	DriverStationLCD ds = DriverStationLCD.getInstance();

	public Turn() {
		db = CommandBase.gyroSub;
		requires(db);
	}

	protected void initialize() {

	}

	protected void execute() {
		double opX = OI.gamepad.getRightStickX(); // Get y-axis value from operator right stick
		if (opX < 0.2 && opX > -0.2)
			opX = 0;
		double newSetpoint = db.getSetpoint() + opX;
		if (newSetpoint < -360 || newSetpoint > 360)
			newSetpoint = 0;
		db.setSetpoint(newSetpoint);

		Line line = DriverStationLCD.Line.kUser2;
		String message = "SetPoint: " + db.getSetpoint();
		ds.println(line, 1, message);
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub

	}

	protected void interrupted() {

	}

}
