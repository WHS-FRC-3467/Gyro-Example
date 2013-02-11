package org.usfirst.frc3467.commands.visionTracking;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.VisionTracking;

public class UpdateVT extends CommandBase {
	VisionTracking vt;
	double diff;

	public static boolean finished = false;

	public UpdateVT() {
		vt = VisionTracking.getInstance();
		requires(vt);
	}

	protected void initialize() {
		
	}

	protected void execute() {
		VisionTracking.getInstance().update();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {

	}

}
