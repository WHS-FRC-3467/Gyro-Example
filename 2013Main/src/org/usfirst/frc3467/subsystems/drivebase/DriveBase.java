package org.usfirst.frc3467.subsystems.drivebase;

import org.usfirst.frc3467.RobotMap;
import org.usfirst.frc3467.commands.driveBase.DriveJoysticks;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveBase extends Subsystem {
	
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveJoysticks());
	}


	public static DriveBase instance;
	//If there is no instance of VisionTracking running, make a new one
	public static DriveBase getInstance() {
		if (instance == null)
			instance = new DriveBase();
		return instance;
	}

	private RobotDrive drive;
	Victor vict1;
	Victor vict2;
	Victor vict3;
	Victor vict4;

	public DriveBase() {
		vict1 = new Victor(RobotMap.leftVic1);
		vict2 = new Victor(RobotMap.leftVic2);
		vict3 = new Victor(RobotMap.rightVic1);
		vict4 = new Victor(RobotMap.rightVic2);
		// Create new victors and put them into a RobotDrive
		drive = new RobotDrive(vict1, vict2, vict3, vict4);
		drive.setSafetyEnabled(false);
	}

	public void drive(double left, double right) {
		SmartDashboard.putNumber("Motor Output: ", left);
		SmartDashboard.putNumber("Current Angle: ", DBGyroSub.getInstance().returnPIDInput());
		SmartDashboard.putNumber("Set Angle: ", DBGyroSub.getInstance().getSetpoint());
		drive.tankDrive(left, right);
	}

}
