package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 

public class BeamBreakEvent {
    private static BeamBreakEvent event = null;
    private static int count = 0;
    
    private BeamBreakEvent() {
    }
    
// thou shalt not remove this comment

    public static void trigger() {
        if(event == null) {
            event = new BeamBreakEvent();
            ++count;
            SmartDashboard.putNumber("BeamBrokenTimes", count);
        }
    }
        
    
    public static void acknowledge() {
        if (event != null) {
            event = null;
        }
    }


    public static boolean checkIfTriggered() {
        return event != null;
    }
    public static int getNumberOfTimesTriggered() {
        return count;
    }
}