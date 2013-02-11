package org.usfirst.frc3467.commands.driveBase.gyro;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.drivebase.DBGyroSub;

public class DBSetGyro extends CommandBase {
	double setPoint = 0;
	DBGyroSub gyroSub;

	public DBSetGyro(double sp) {
		gyroSub = DBGyroSub.getInstance();
		setPoint = sp;
		// Sets the setpoint variable equal to the variable
		// passed into the new instance of the class
	}

	protected void initialize() {

	}

	protected void execute() {
		if (setPoint > 360)
			setPoint = 0 + (setPoint - 360);
		if (setPoint < -360)
			setPoint = 0 + (setPoint + 360);
		// Note this check is for only 360 degrees above 360 degrees!
		// If the setPoit is something like 900, this check will not work.
		// The robot will continuously spin. Have not bothered to fix it
		// Because the setPoint should never be above 360 to begin with.
		gyroSub.setSetpoint(setPoint);
	}

	protected void interrupted() {

	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

}
