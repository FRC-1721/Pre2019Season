package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveTrain;

public class driveReckon extends Command {
  public driveReckon() {
    //requires(DriveTrain);
    setTimeout(0.9); //Timeout command
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    DriveTrain.arcadeDrive(RobotMap.Boistick, RobotMap.portMotor, RobotMap.starboardMotor, true, 0.5, 0.5);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    DriveTrain.arcadeDrive(RobotMap.Boistick, RobotMap.portMotor, RobotMap.starboardMotor, true, 0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
