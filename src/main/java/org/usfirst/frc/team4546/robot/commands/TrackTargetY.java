package org.usfirst.frc.team4546.robot.commands;

import org.usfirst.frc.team4546.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class TrackTargetY extends PIDCommand {

	//This command handles tracking the target on the Y-axis
	
	static double p = 0.01;
	static double i = 0;
	static double d = 0;
	static double tolerance = 2.0f;
	static double minimumInput = 0;
	static double maximumInput = 200;
	double turnRate;
	double targetDistanceY;
	
	public TrackTargetY() {
		super(p, i, d);
		getPIDController().setInputRange(minimumInput, maximumInput);
		getPIDController().setOutputRange(-1.0, 1.0);
		getPIDController().setAbsoluteTolerance(tolerance);
		getPIDController().setContinuous(true);										
	}
	
	protected double returnPIDInput() {
		
		return 0;//100 - Robot.table.getNumber("midpointY", 100);
	}

	
	protected void usePIDOutput(double output) {
		turnRate = output;

	}

	
	protected void end() {
		

	}

	
	protected void execute() {
		Robot.cannon.setPitchMotor(turnRate, 1);

	}

	
	protected void initialize() {
		

	}

	
	protected void interrupted() {
		
		//gullible
	}

	
	protected boolean isFinished() {
		
		return false;//Robot.table.getNumber("midpointY", 100) > 85 && Robot.table.getNumber("midpointY", 100) < 115;
	}

}
