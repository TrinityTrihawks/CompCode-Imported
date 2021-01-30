package frc.robot.commands.shooter;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Shooter;

import frc.robot.PIDConstants;

/**
 * Shoot at given velocity using given feedback constants
 * Also incorporates real-time adjustments to velocity using double supplier between [-1, 1]
 */
public class ShootClosedLoop extends SequentialCommandGroup {

    public ShootClosedLoop(Shooter shooter, DoubleSupplier adjustment, double vel, 
                            PIDConstants constants) {
        addCommands(
            new ShooterSetConstants(shooter, constants),
            new ShootClosedLoopVelocityOnly(shooter, adjustment, vel)
        );
    }

    
    /**
     * This version of the constructor disables adjustment
     */
    public ShootClosedLoop(Shooter shooter, double vel,
                                PIDConstants constants) {
        this(shooter, ()->0, vel, constants);
    }
}