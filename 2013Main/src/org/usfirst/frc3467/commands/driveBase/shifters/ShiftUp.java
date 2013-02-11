package org.usfirst.frc3467.commands.driveBase.shifters;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.drivebase.Shifters;

public class ShiftUp extends CommandBase {

	Shifters shiftSub;

	public ShiftUp() {
		shiftSub = Shifters.getInstance();
		requires(shiftSub);
		// Makes this command interrupt another
		// command using the same subsystem
		setTimeout(0.1); // Set the time the piston should fire
	}

	protected void execute() {
		CommandBase.shifters.shiftUp(); // Shift up
	}

	protected void initialize() {

	}

	protected void interrupted() {
		this.end(); // If user shifts while it is shifting,
		// Then turn everything off and start new command
	}

	protected boolean isFinished() {
		return isTimedOut();
		// If the piston has finished firing
	}

	protected void end() {
		CommandBase.shifters.shiftOff();
		// Shut off solenoid
	}
}