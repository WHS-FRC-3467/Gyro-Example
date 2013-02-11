package org.usfirst.frc3467.commands.shooter.loader;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.shooter.Loader;

public class LoadOut extends CommandBase {

	Loader loaderSub;

	public LoadOut() {
		loaderSub = Loader.getInstance();
		requires(loaderSub);
		// Makes this command interrupt another
		// command using the same subsystem
		setTimeout(0.1); // Set the time the piston should fire
	}

	protected void execute() {
		loaderSub.loadOut();// Shift down
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