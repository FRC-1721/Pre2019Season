package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import frc.robot.subsystems.DriveTrain;
import frc.robot.commands.automatic;

public class Robot extends TimedRobot {
  //public static DriveTrain m_subsystem = new DriveTrain();
  public static OI m_oi;

  Command m_autonomousCommand;
  SendableChooser<Command> autochooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    m_oi = new OI();
    autochooser.addObject("Josh has dumb", new automatic());
    autochooser.addObject("Jk I was kidding", new automatic());
    autochooser.addObject("No jkjk he's dumb", new automatic());
    SmartDashboard.putData("Auto mode", autochooser);

    SmartDashboard.putNumber("Robot Speed", 0);
    SmartDashboard.putNumber("Robot Steerage", 0);
    
  //Init Sticks
    RobotMap.Boistick = new Joystick(RobotMap.BoyStickPort);

    //Init Motors
    RobotMap.portMotor = new WPI_TalonSRX(RobotMap.portMotorCAN);
    RobotMap.starboardMotor = new WPI_TalonSRX(RobotMap.starboardMotorCAN);
  }

  @Override
  public void robotPeriodic() {
    /* This void runs every packet (use for things that run all the time no 
     * matter the mode)
     */
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    m_autonomousCommand = autochooser.getSelected();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    //This function is called periodically during autonomous.
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {

    //Turn off Auto when teleop Init starts
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    //This function is called periodically during operator control.
    Scheduler.getInstance().run();

    double rawThro = RobotMap.Boistick.getRawAxis(1); //Get raw x axis
    double rawSteer = RobotMap.Boistick.getRawAxis(2); //Get raw y axis

    SmartDashboard.putNumber("Robot Speed", rawThro); //Put the values on the smart
    SmartDashboard.putNumber("Robot Steerage", rawSteer);

    //Move these to drivetrain!
    RobotMap.starboardMotor.set((rawThro - rawSteer) * -1); //Use the axies
    RobotMap.portMotor.set(rawThro + rawSteer); //Use the axies
  }

  @Override
  public void testPeriodic() {
    //This function is called periodically during test mode.
  }
}
