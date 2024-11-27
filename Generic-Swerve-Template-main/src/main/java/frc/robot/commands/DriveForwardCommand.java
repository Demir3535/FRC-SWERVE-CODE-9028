package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotConstants;
import frc.robot.RobotConstants.TeleopConstants;
import frc.robot.RobotConstants.PortConstants.Controller;
import frc.robot.RobotConstants.DrivetrainConstants;
import frc.robot.RobotConstants.SubsystemEnabledConstants;
import frc.robot.RobotContainer.UserPolicy;
import frc.robot.subsystems.drive.DriveSubsystem;

public class DriveForwardCommand extends Command {
    private final DriveSubsystem drive;

    public DriveForwardCommand(DriveSubsystem drive) {
        this.drive = drive;
        addRequirements(drive);
    }

    @Override
    public void end(boolean interrupted) {
        drive.drive(0, 0, 0, DrivetrainConstants.FIELD_RELATIVE, true);
    }

    @Override
    public void execute() {
        drive.drive(0.1, 0, 0, true, true);
        System.out.println("Deneme");
        }

    @Override
    public void initialize() {
        drive.drive(0, 0, 0, DrivetrainConstants.FIELD_RELATIVE, true);
        
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}

