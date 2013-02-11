package org.usfirst.frc3467.commands;

import org.usfirst.frc3467.OI;
import org.usfirst.frc3467.subsystems.drivebase.DriveBase;
import org.usfirst.frc3467.subsystems.drivebase.DBGyroSub;
import org.usfirst.frc3467.subsystems.drivebase.Shifters;
import org.usfirst.frc3467.subsystems.shooter.Loader;

import edu.wpi.first.wpilibj.command.Command;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 * 
 * @author Author
 */
public abstract class CommandBase extends Command {

	public static OI oi;
	public static DriveBase driveBase;
	public static Shifters shifters;
	public static DBGyroSub gyro;
	public static Loader loader;

	// Create a single static instance of all of your subsystems
	// public static SendableChooser rb;

	public static void init() {
		// This MUST be here. If the OI creates Commands (which it very likely
		// will), constructing it during the construction of CommandBase (from
		// which commands extend), subsystems are not guaranteed to be
		// yet. Thus, their requires() statements may grab null pointers. Bad
		// news. Don't move it.
		oi = new OI();
		driveBase = DriveBase.getInstance();
		shifters = Shifters.getInstance();
		gyro = DBGyroSub.getInstance();
		loader = Loader.getInstance();
	}

	public CommandBase(String name) {
		super(name);
	}

	public CommandBase() {
		super();
	}
}
