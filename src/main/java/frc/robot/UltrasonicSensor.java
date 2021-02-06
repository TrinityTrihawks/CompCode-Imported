package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import static frc.robot.Constants.UltrasonicSensorConstants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class UltrasonicSensor {
    private final AnalogInput input = new AnalogInput(UltrasonicSensorConstants.pin);
    private double rawValue;
    private double currentDistance;

    public double getCurrentDistance() {
        getDistance();
        SmartDashboard.putNumber("Ultrasonic Sensor Distance", currentDistance);
        return currentDistance;
    }

    private void getDistance() {
        rawValue = input.getValue();
        currentDistance = rawValue * UltrasonicSensorConstants.voltsToCm;
    }
}
