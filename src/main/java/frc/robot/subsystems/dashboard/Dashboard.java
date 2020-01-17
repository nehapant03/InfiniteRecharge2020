package frc.robot.subsystems.dashboard;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Dashboard extends SubsystemBase{

    ShuffleboardTab pidTab = Shuffleboard.getTab("auto align pid");
    double defaultP = .016;
    double defaultD = 1;

    public NetworkTableEntry kP = pidTab.add("P", defaultP).getEntry();
    public NetworkTableEntry kD = pidTab.add("D", defaultD).getEntry(); 

    ShuffleboardTab shooterTab = Shuffleboard.getTab("shooter power");
    double defaultPower = .5;

    public NetworkTableEntry power = shooterTab.add("power", defaultPower).getEntry();

    
    public Dashboard(){}

    public double getkP(){
        return kP.getDouble(defaultP);
    }
    
    public double getkD(){
        return kD.getDouble(defaultD);
    }

    public double getPower(){
        return power.getDouble(defaultPower);
    }

    @Override
    public void periodic(){}

}