// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  Spark leftFront;
  Spark leftBack;
  Spark rightFront;
  Spark rightBack;

  MotorControllerGroup leftMotors;
  MotorControllerGroup rightMotors;

  DifferentialDrive drive;

  /** Creates a new DriveTrain. */
  public DriveTrain() {

    leftFront = new Spark(Constants.LEFT_FRONT);
    leftBack = new Spark(Constants.LEFT_BACK);
    rightFront = new Spark(Constants.RIGHT_FRONT);
    rightBack = new Spark(Constants.RIGHT_BACK);

    leftMotors = new MotorControllerGroup(leftBack, leftFront);
    rightMotors = new MotorControllerGroup(rightBack, rightFront);

    drive = new DifferentialDrive(leftMotors, rightMotors);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveWithController (XboxController controller, double speed) {

    drive.arcadeDrive(controller.getRawAxis(Constants.XBOX_LEFT_Y_AXIS)*speed, controller.getRawAxis(Constants.XBOX_LEFT_X_AXIS)*speed);
  }
 
   public void driveForward(double speed) {

    drive.tankDrive(speed, speed);

   }

   public void stop() {

    drive.stopMotor();

   }

}
