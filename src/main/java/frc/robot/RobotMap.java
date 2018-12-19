package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;

public class RobotMap {

  //Joysticks
  public static Joystick Boistick;
  public static int BoyStickPort = 0; //Lol boystick port
  
  //CAN Ports
  public static int starboardMotorCAN = 0; //Define Starboard Motor
  public static int portMotorCAN = 1; //Define Port Motor

  //Types
  public static WPI_TalonSRX starboardMotor;
  public static WPI_TalonSRX portMotor;
}
