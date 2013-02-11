package org.usfirst.frc3467.subsystems;

import org.usfirst.frc3467.CommandBasedRobot;
import org.usfirst.frc3467.commands.visionTracking.UpdateVT;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionTracking extends Subsystem {

	protected void initDefaultCommand() {
		// Set UpdateVT as the default command
		this.setDefaultCommand(new UpdateVT());
		// UpdateVT grabs values from the NetworkTable
		// and insures that the everything is working smoothly.
		// If not it will not allow for image tracking
	}

	public static VisionTracking instance;
	//If there is no instance of VisionTracking running, make a new one
	public static VisionTracking getInstance() {
		if (instance == null)
			instance = new VisionTracking();
		return null;
	}

	public static double cachedAzimuth = 0.0;
	
	public VisionTracking() {
		
	}
	
	public void update() {
		try {
			SmartDashboard.putNumber("AZIMUTH: ", CommandBasedRobot.table.getNumber("azimuth"));
		} catch (Exception e) {
			System.out.println("ERROR: Cannot get values from Network table: datatable");
			System.out.println("       Perhaps vision tracking plugin is not up!");
		}
	}
}
