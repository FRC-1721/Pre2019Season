package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.driveReckon;
import frc.robot.subsystems.DriveTrain;

//import frc.robot.RobotMap;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  Joystick stick = new Joystick(0);
  public Button Reckon = new JoystickButton(stick, 1);

  public OI (){
    Reckon.whileHeld(new driveReckon());
  }
}
