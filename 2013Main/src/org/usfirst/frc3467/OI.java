package org.usfirst.frc3467;

import org.usfirst.frc3467.commands.driveBase.gyro.DBSetGyro;
import org.usfirst.frc3467.commands.driveBase.shifters.ShiftDown;
import org.usfirst.frc3467.commands.driveBase.shifters.ShiftUp;
import org.usfirst.frc3467.commands.visionTracking.DriveVTracking;
import org.usfirst.frc3467.subsystems.drivebase.DBGyroSub;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
	public static Joystick joystick1 = new Joystick(1);
	public static Joystick joystick2 = new Joystick(2);
	public static Gamepad gamepad = new Gamepad(3);

	Button gamepadShiftUp = new JoystickButton(gamepad, Gamepad.rightBumper);
	Button gamepadShiftDown = new JoystickButton(gamepad, Gamepad.leftBumper);
	Button gamepadSetSetpointGyro = new JoystickButton(gamepad, Gamepad.leftTrigger);
	Button gamepadActivateGyro = new JoystickButton(gamepad, Gamepad.rightTrigger);

	Button joyShiftUp = new JoystickButton(joystick2, 5);
	Button joyShiftDown = new JoystickButton(joystick2, 4);
	Button joySetSetpointGyro = new JoystickButton(joystick1, 2);
	Button joyActivateGyro = new JoystickButton(joystick1, 1);

	public OI() {
		gamepadShiftUp.whenPressed(new ShiftUp());
		gamepadShiftDown.whenPressed(new ShiftDown());
		joyShiftUp.whenPressed(new ShiftUp());
		joyShiftDown.whenPressed(new ShiftDown());

		gamepadSetSetpointGyro.whileHeld(new DBSetGyro(DBGyroSub.getInstance().returnPIDInput()));
		gamepadActivateGyro.whileHeld(new DriveVTracking());
		joySetSetpointGyro.whileHeld(new DBSetGyro(DBGyroSub.getInstance().returnPIDInput()));
		joyActivateGyro.whileHeld(new DriveVTracking());

		new SmartDashboard();
	}
}
