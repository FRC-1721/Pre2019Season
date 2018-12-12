package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Made by jae
 * Lol why u reading this
 */
public class DriveTrain extends Subsystem {
  public static void arcadeDrive(Joystick drivestick, WPI_TalonSRX port, WPI_TalonSRX starboard, boolean manual, double manualaxis0, double manualaxis1){

    double rawThro = 0;
    double rawSteer = 0;

    if(manual == true){ //If true, we are in manual mode, and the operator is driving the robot
      rawThro = drivestick.getRawAxis(1); //Get raw x axis
      rawSteer = drivestick.getRawAxis(2); //Get raw y axis
    }
    else //If we are not in manual mode, we are being controled by the robot.
    {
      rawThro = manualaxis0;
      rawSteer = manualaxis1;
    }

    //Smart Dashboard
    SmartDashboard.putNumber("Robot Speed", rawThro); //Put the values on the smart
    SmartDashboard.putNumber("Robot Steerage", rawSteer);

    starboard.set((rawThro - rawSteer) * -1); //Use the axies (reversed)
    port.set(rawThro + rawSteer); //Use the axies
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
