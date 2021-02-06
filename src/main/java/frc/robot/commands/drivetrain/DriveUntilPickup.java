package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.BeamBreakEvent;
import frc.robot.commands.storage.AutomaticStorage;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Storage;

public class DriveUntilPickup extends ParallelCommandGroup {
    private Drivetrain drivetrain;

    public DriveUntilPickup(Drivetrain drivetrain, Storage storage) {
        addCommands(new AutomaticStorage(storage));
        this.drivetrain = drivetrain;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        if (BeamBreakEvent.checkIfTriggered()) {
            BeamBreakEvent.acknowledge();
            end(false);
        }

        drivetrain.driveOpenLoop(0.3, 0.3); // TODO: tune these
    }

    @Override
    public void end(boolean interrupted) {
    }
}