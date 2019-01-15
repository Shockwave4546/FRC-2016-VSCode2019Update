package org.usfirst.frc.team4546.robot;

import edu.wpi.first.wpilibj.SPI;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;


import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import com.kauailabs.navx.frc.AHRS;
import com.ctre.phoenix.motorcontrol.can.*;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static AHRS drivetrainAHRS;
	public static Talon drivetrainLeft;
	public static Talon drivetrainRight;
	public static DifferentialDrive drivetrainChassis;	
	
	public static TalonSRX cannonYawMotor;
	public static TalonSRX cannonPitchMotor;
	public static TalonSRX cannonFireLeft;
	public static TalonSRX cannonFireRight;
	public static Servo cannonFeedServo;
	public static DigitalInput cannonLimitSwitch;
	public static AnalogInput cannonPitchEncoder;
	public static AnalogInput cannonYawEncoder;
	
	public static void init()	{


		//Drivetrain Objects
		drivetrainLeft = new Talon(0);
		//LiveWindow.addActuator("Drivetrain", "Left Motor", (Talon) drivetrainLeft);
		
		drivetrainRight = new Talon(1);
		//LiveWindow.addActuator("Drivetrain", "Right Motor", (Talon) drivetrainRight);
		
		drivetrainChassis = new DifferentialDrive(drivetrainLeft, drivetrainRight);
		
		drivetrainAHRS = new AHRS(SPI.Port.kMXP);
        //LiveWindow.addActuator("Drivetrain", "Gyro", (AHRS) drivetrainAHRS);
		
		//Drivetrain config
        drivetrainChassis.setSafetyEnabled(true);
		drivetrainChassis.setExpiration(0.1);
        //drivetrainChassis.setSensitivity(0.5);
        drivetrainChassis.setMaxOutput(1.0);
        
        //drivetrainChassis.setInvertedMotor(DifferentialDrive.MotorType.kRearRight, true);
        
        cannonYawMotor = new TalonSRX(1);
        //LiveWindow.addActuator("Cannon", "Yaw Motor", (TalonSRX) cannonYawMotor);
        
      
        cannonYawMotor.setInverted(true);
        
        //Cannon objects
        cannonPitchMotor = new TalonSRX(0);
        //LiveWindow.addActuator("Cannon", "Pitch Motor", (TalonSRX) cannonPitchMotor);
        
        
        
        cannonFireLeft = new TalonSRX(2);
        //LiveWindow.addActuator("Cannon", "Left Firing Motor", (TalonSRX) cannonFireLeft);
    
        cannonFireRight = new TalonSRX(3);
     
        cannonFireRight.setInverted(true);
        
        cannonFeedServo = new Servo(2);
        //LiveWindow.addActuator("Cannon", "Feed Servo", (Servo) cannonFeedServo);
        
        cannonLimitSwitch = new DigitalInput(0);
       // LiveWindow.addSensor("Cannon", "Limit Switch", (DigitalInput) cannonLimitSwitch);
        
        cannonPitchEncoder = new AnalogInput(1);
        //LiveWindow.addSensor("Cannon", "Pitch Encoder", (AnalogInput) cannonPitchEncoder);
        
        cannonYawEncoder = new AnalogInput(0);
        //LiveWindow.addSensor("Cannon", "Yaw Encoder", (AnalogInput) cannonYawEncoder);
        
	}
	
}