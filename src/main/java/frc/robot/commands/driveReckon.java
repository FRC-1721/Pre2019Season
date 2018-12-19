package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveTrain;

public class driveReckon extends Command {
  public driveReckon() {
    //requires(DriveTrain);
    //setTimeout(2000); //Timeout command
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //DriveTrain.arcadeDrive(RobotMap.Boistick, RobotMap.portMotor, RobotMap.starboardMotor, true, 0.5, 0.5);
    RobotMap.starboardMotor.set(-0.8); //Use the axies (reversed)
    RobotMap.portMotor.set(0.8); //Use the axies
    //Timer.delay(2);
    SmartDashboard.putBoolean("driveReckon", true);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true; //Is done
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    SmartDashboard.putBoolean("driveReckon", false);
    DriveTrain.arcadeDrive(RobotMap.Boistick, RobotMap.portMotor, RobotMap.starboardMotor, true, 0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
