package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.BeamBreakEvent;
import frc.robot.subsystems.Drivetrain;

public class DriveUntilPickup extends CommandBase {
    private Drivetrain drivetrain;

    public DriveUntilPickup(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        if (BeamBreakEvent.checkIfTriggered()) {
            BeamBreakEvent.acknowledge();
            cancel();
        }

        drivetrain.driveOpenLoop(0.3, 0.3); // TODO: tune these
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.driveOpenLoop(0, 0);
    }
}