package org.usfirst.frc.team4546.robot.subsystems;


import org.usfirst.frc.team4546.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4546.robot.commands.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;



public class Cannon extends Subsystem {

	TalonSRX fireRight = RobotMap.cannonFireRight;
	TalonSRX fireLeft = RobotMap.cannonFireLeft;
	TalonSRX yawMotor = RobotMap.cannonYawMotor;
	TalonSRX pitchMotor = RobotMap.cannonPitchMotor;
	Servo feedServo = RobotMap.cannonFeedServo;
	DigitalInput ballLimit = RobotMap.cannonLimitSwitch;
	AnalogInput pitchEncoder = RobotMap.cannonPitchEncoder;
	AnalogInput yawEncoder = RobotMap.cannonYawEncoder;

	//Set speed of pitch motor
	public void setPitchMotor(double move, double speed) {
		
		/*if(Robot.leftLimit <= Robot.cannon.getYaw() && Robot.rightLimit >= Robot.cannon.getYaw())	{

			pitchMotor.set(move*speed);
		}*/
		
		pitchMotor.set(ControlMode.Current, move*speed);
	}
	
	//Set speed of yaw motor
	public void setYawMotor(double move, double speed) {

		/*if(Robot.upperLimit >= Robot.cannon.getPitch() && Robot.lowerLimit <= Robot.cannon.getPitch())	{

			yawMotor.set(move*speed);
		}*/
		yawMotor.set(ControlMode.Current, move*speed);
	}
	
	//Set speed of left firing motor
	public void setFireLeft(double speed) {
		fireLeft.set(ControlMode.Current, speed);
	}
	
	//Set speed of right firing motor
	public void setFireRight(double speed) {
		
		fireRight.set(ControlMode.Current, speed);
	}
	
	//Set angle of feed servo
	public void setFeedServo(double servoAngle) {
		feedServo.setAngle(servoAngle);
	}
	
	//Returns true when ball is loaded
	public boolean hasBall()	{
		
		return ballLimit.get();
	}
	
	//Raw encoder voltage for debug
	public double getRawPitch()	{
		
		return pitchEncoder.getVoltage();
	}
	
	//Pitch of cannon
	public double getPitch()	{
		
		if(pitchEncoder.getVoltage()*72 <= 180)	{
			return -(72*pitchEncoder.getVoltage());
		}	else	{
			return 360 - 72*pitchEncoder.getVoltage();
		}
		
	}
	
	//Raw encoder voltage for debug
	public double getRawYaw()	{
		
		return yawEncoder.getVoltage();
	}
	
	//Yaw of cannon
	public double getYaw()	{
		
		if(yawEncoder.getVoltage() <= 2.5)	{
			return 72*yawEncoder.getVoltage();
		}	else	{
			return 72*yawEncoder.getVoltage() - 360;
		}
	}
	
	protected void initDefaultCommand() {
		
		setDefaultCommand(new ControlCannon());
	}
	
}
