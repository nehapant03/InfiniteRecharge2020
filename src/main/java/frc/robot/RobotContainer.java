/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.team7419.PaddedXbox;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.dashboard.Dashboard;
import frc.robot.subsystems.drive.*;
import frc.robot.subsystems.intake.*;
import frc.robot.subsystems.shooter.*;
import frc.robot.subsystems.vision.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {

  private final DriveBaseSub driveBase = new DriveBaseSub();
  private final ShooterSub shooter = new ShooterSub();
  private final Dashboard dashboard = new Dashboard();
  private final PaddedXbox joystick = new PaddedXbox();
  private final LimelightSub limelight = new LimelightSub();
  private final LoaderSub loader = new LoaderSub();
  private final IntakeSub intake = new IntakeSub();
  private final RevolverSub revolver = new RevolverSub();

  private final ArcadeDrive arcade = new ArcadeDrive(joystick, driveBase, 1, .4);
  private final TurnToTx turnToTx = new TurnToTx(driveBase, limelight, dashboard);
  private final IntakeDefault intakeDefault = new IntakeDefault(intake, joystick);
  private final CalibrateFalcon calibrate = new CalibrateFalcon(shooter, joystick);

  public RobotContainer() {
    manualButtonBindings();
  }

  private void mechTesterButtonBindings() { // for dj

    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonX.value)
        .whileHeld(new RunOneSide(driveBase, "left", dashboard, true));
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonA.value)
        .whileHeld(new RunOneSide(driveBase, "left", dashboard, false)); 
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonY.value)
      .whileHeld(new RunOneSide(driveBase, "right", dashboard, false));
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonY.value)
      .whileHeld(new RunOneSide(driveBase, "right", dashboard, true)); 
  }

  private void codeTestButtonBindings(){ // for programmer

    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonA.value)
      .whenPressed(turnToTx); // limelight test command
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonX.value)
      .whenPressed(arcade);
  }

  private void manualButtonBindings(){

    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonY.value)
    .whileHeld(new PercentOutput(shooter, dashboard));
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonA.value)
    .whileHeld(new OpenLoopFeedforward(shooter, dashboard), true);
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonShoulderL.value)
    .whileHeld(new RunRevolver(revolver, .5)); // previously .35
    new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadButtonShoulderR.value)
    .whileHeld(new RunRevolver(revolver, -.5)); // previously .35

    new POVButton(joystick, 0).whileHeld(new RunLoader(loader, .3)); 
    new POVButton(joystick, 180).whileHeld(new RunLoader(loader, -.3));

    // new POVButton(joystick, 90).whileHeld(new RunIntake(intake, joystick, .5)); 
    // new POVButton(joystick, 270).whileHeld(new RunIntake(intake, joystick, -.5)); 

    /* untested button bindings for intake and triggers */
    // new Trigger().toggleWhenActive(new RunIntake(intake, joystick, -.5));
    // new JoystickButton(joystick, PaddedXbox.F310Map.kGamepadAxisRightTrigger.value)
    // .whileHeld(new RunIntake(intake, joystick, -.5));
  }

  public Command getDefaultCommand(){return arcade;}
  public Command getLimelightTest(){return turnToTx;}
  
  public void scheduleDefaultCommands(){
    arcade.schedule();
    // calibrate.schedule();
    intakeDefault.schedule();
  }
}
