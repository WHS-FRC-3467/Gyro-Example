package org.usfirst.frc3467;

public class RobotMap {

	// ////////////// DriveBase ////////////// //
	// Victors
	public static int leftVic1 = 1;
	public static int leftVic2 = 2;
	public static int rightVic1 = 3;
	public static int rightVic2 = 4;
	// Gyro
	public static int gyroAnalogPort = 1;
	public static double gyroKp = 0.05;
	public static double gyroKi = 0.002;
	public static double gyroKd = 0.05;
	// Encoders
	public static int leftSigA = 8;
	public static int leftSigB = 7;
	public static int rightSigA = 12;
	public static int rightSigB = 11;
	public static double encoderKp = 0.05;
	public static double encoderKi = 0.002;
	public static double encoderKd = 0.05;
	// Solenoids
	public static int solenoidShiftDown = 1;
	public static int solenoidShiftUp = 2;

	// ////////////// Shooter ////////////// //
	// Solenoids
	public static int solenoidLoadOut = 3;
	public static int solenoidLoadIn = 4;
}
