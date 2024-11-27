package frc.robot.commands.drive;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.path.PathConstraints;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotConstants.PathPlannerConstants;
import frc.robot.subsystems.drive.DriveSubsystem;
import frc.robot.utils.CowboyUtils;

public class PathFindToPose {
    DriveSubsystem driveSubsystem;
    public static Command pathfindingCommand;

    // Create the constraints to use while pathfinding (Speeds and acceleration)
    static PathConstraints constraints = new PathConstraints(
            PathPlannerConstants.MAX_VELOCITY, PathPlannerConstants.MAX_ACCELERATION,
            Units.degreesToRadians(PathPlannerConstants.MAX_ANGULAR_SPEED),
            Units.degreesToRadians(PathPlannerConstants.MAX_ANGULAR_ACCELERATION));

    public static Command pathToPoseCommand(Pose2d target) {
        pathfindingCommand = AutoBuilder.pathfindToPose(
                target,
                constraints,
                0.0,
                0.0);
        return pathfindingCommand;
    }

    public static Command alignWithSpeakerCommand() {
        return pathToPoseCommand(CowboyUtils.testPose);
    }

}
