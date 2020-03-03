package frc.robot.snippits;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.PowerConstants;
import frc.robot.subsystems.intake.LoaderSub;
import frc.robot.subsystems.intake.RevolverSub;
import frc.robot.subsystems.intake.RunLoader;
import frc.robot.subsystems.intake.RunRevolver;
import frc.robot.subsystems.shooter.GetToTargetVelocity;
import frc.robot.subsystems.shooter.ShooterSub;

public class ShotsButton extends ParallelCommandGroup {
  
  private ShooterSub shooter;
  private LoaderSub loader;
  private RevolverSub revolver;
  private double shooterSpeed;
  private double revolverSpeed;
  // private boolean operator = false;  //so i want to make a boolean passed thru the constructor that
                                        //decides which dashboard coeff to take but for now we're gonna go with separate files :/
  
  public ShotsButton(ShooterSub shooter, LoaderSub loader, RevolverSub revolver, double shooterSpeed,
      double revolverSpeed) {
    this.shooter = shooter;
    this.loader = loader;
    this.revolver = revolver;
    this.shooterSpeed = shooterSpeed;
    this.revolverSpeed = revolverSpeed;

    addCommands(new GetToTargetVelocity(shooter, shooterSpeed));
    addCommands(new RunLoader(loader, PowerConstants.LoaderShotsButton.val, true));
    addCommands(new RunRevolver(revolver, revolverSpeed, true));
  }

}