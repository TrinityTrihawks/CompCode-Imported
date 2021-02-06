package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.UltrasonicSensor;
import frc.robot.commands.drivetrain.DriveUntilPickup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Storage;

public class GalacticSearchControl extends SequentialCommandGroup {
    private UltrasonicSensor uss;
    private PathColor side = PathColor.Red;
    private byte path = 1;
    private double[][] angles = new double[4][3]; //TODO: set these

    private enum PathColor {
        Red, Blue
    }

    public GalacticSearchControl(UltrasonicSensor uss, Drivetrain drivetrain, Storage storage) {
        this.uss = uss;
        setPathAndColor();
        addCommands(
            new DriveUntilPickup(drivetrain, storage),
            new TurnUsingGyro(drivetrain, ) // TODO: fill this out
        );

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
