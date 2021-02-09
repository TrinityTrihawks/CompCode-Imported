package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.UltrasonicSensor;
import frc.robot.commands.drivetrain.DriveUntilPickup;
import frc.robot.commands.drivetrain.TurnUsingGyro;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Storage;

public class GalacticSearchControl extends SequentialCommandGroup {
    private UltrasonicSensor uss;
    private PathColor side = PathColor.Red;
    private byte path = 1;
    private int anglesIndex = 0;
    private double[][] angles = {
            { 26.565, -98.13, 71.565 }, // path1, red
            { 45.0, -90.0, 45.0 }, // path1, blue
            { -71.565, 98.13, -26.565 }, // path2, red
            { -45.0, 90.0, -45.0 }  // path2, blue
    }; 

    private enum PathColor {
        Red, Blue
    }

    public GalacticSearchControl(UltrasonicSensor uss, Drivetrain drivetrain) {
        this.uss = uss;

        setPathAndColor();
        setAnglesIndex();
        addCommands(
            new DriveUntilPickup(drivetrain),
            new TurnUsingGyro(drivetrain, angles[anglesIndex][0], 0.3),
            new DriveUntilPickup(drivetrain),
            new TurnUsingGyro(drivetrain, angles[anglesIndex][1], 0.3),
            new DriveUntilPickup(drivetrain),
            new TurnUsingGyro(drivetrain, angles[anglesIndex][2], 0.3),
            new DriveUntilPickup(drivetrain)
        );

        addRequirements(drivetrain);
    }
    
    private void setPathAndColor() {
        double distance = uss.getCurrentDistance();
        switch ((int) (distance / 2.54 / 12)) {
            case 2:
                side = PathColor.Blue;
                path = 1;
                break;
            case 7:
                side = PathColor.Red;
                path = 1;
                break;
            case 5:
                side = PathColor.Blue;
                path = 2;
                break;
            case 10:
                side = PathColor.Red;
                path = 2;
                break;
        }
    }

    private void setAnglesIndex() {
        if (path == 1) {
            if (side == PathColor.Red) {
                anglesIndex = 0;
            } else {
                anglesIndex = 1;
            }
        } else if (path == 2) {
            if (side == PathColor.Red) {
                anglesIndex = 2;
            } else {
                anglesIndex = 3;
            }
        }
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
    }
}
