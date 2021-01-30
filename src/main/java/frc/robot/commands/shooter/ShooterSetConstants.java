package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.PIDConstants;
import frc.robot.subsystems.Shooter;

/**
 * This command sets the shooter's feedback loop constants and then quits
 */
public class ShooterSetConstants extends InstantCommand {
  private final Shooter shooter;
  
  private PIDConstants pidConstants;

  // Creates a new ShooterSetConstants command
  public ShooterSetConstants(Shooter shooter, PIDConstants constants) {
    this.shooter = shooter;
    pidConstants = constants;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.updatePIDConstants(pidConstants);
  }


}