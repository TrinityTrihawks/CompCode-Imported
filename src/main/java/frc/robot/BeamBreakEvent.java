package frc.robot;

public class BeamBreakEvent {
    private static BeamBreakEvent event = null;

    private BeamBreakEvent() {
    }

    public static void trigger() {
        if(event == null) 
            event = new BeamBreakEvent();
        
    }

    public static void acknowledge() {
        if (event != null)
            event = null;
    }
}