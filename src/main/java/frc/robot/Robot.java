/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

  private RobotContainer robotContainer;
  // private final FaceplantThenShoot faceplantThenShoot = new FaceplantThenShoot(robotContainer);


  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();
    // CameraServer.getInstance().startAutomaticCapture();
  }

  
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }


  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    // faceplantThenShoot.schedule();
    // robotContainer.getAutoCommand().schedule();
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // robotContainer.getAutoCommand().cancel();
    robotContainer.setDefaultCommands();
  }

  @Override
  public void teleopPeriodic() {
    // faceplantThenShoot.cancel();
    CommandScheduler.getInstance().run();
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }  
}
