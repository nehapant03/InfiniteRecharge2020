package frc.robot.subsystems.vision;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightSub extends SubsystemBase{

    public LimelightSub(){}

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");

    String current;

    @Override
    public void periodic(){
        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        SmartDashboard.putNumber("tx", x);
        SmartDashboard.putNumber("ty", y);

        // String current = this.getCurrentCommand().getName();
        // SmartDashboard.putString("limelight", current);
        
    }

    public double getTx(){return tx.getDouble(0.0);}
    public double getTy(){return ty.getDouble(0.0);}
}