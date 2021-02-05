package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class PovDownTrigger extends Trigger {
  private final Joystick gamepad;

  public PovDownTrigger(Joystick gamepad) {
    this.gamepad = gamepad;
  } 

  @Override
  // This returns whether the trigger is active
  public boolean get() {
    int povAngle = gamepad.getPOV();
    return ( povAngle==180 || povAngle==225 || povAngle==135 );
  }
}