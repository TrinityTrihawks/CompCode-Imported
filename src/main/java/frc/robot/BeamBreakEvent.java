package frc.robot;


public class BeamBreakEvent {
    private static BeamBreakEvent event = null;
    private static int count = 0;
    
    private BeamBreakEvent() {
    }
    
    public static void trigger() {
        if(event == null) {
            event = new BeamBreakEvent();
            ++count;
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