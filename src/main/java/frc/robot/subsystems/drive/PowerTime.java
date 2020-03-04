package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class PowerTime extends CommandBase {

  private DriveBaseSub driveBase;
  private double power;
  private double time;
  private boolean done;
  private double timestamp;

  /**
   * 
   * @param power powe of which the robot will wun. max of 1.
   * @param time in seconds 
   */

  public PowerTime(DriveBaseSub driveBase, double power, double time) {
    this.driveBase = driveBase;
    this.power = power;
    this.time = time * 1000;
  }

  @Override
  public void initialize() {
    timestamp = System.currentTimeMillis();
    done = false;
  }

  @Override
  public void execute() {
    driveBase.setAll(power);
    
    if(System.currentTimeMillis() - timestamp > time)
      done = true;
    
  }


  @Override
  public void end(boolean interrupted) {
    driveBase.stop();
  }

  @Override
  public boolean isFinished() {
    return done;
  }
}