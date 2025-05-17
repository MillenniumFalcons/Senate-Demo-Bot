/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team3647.frc2020.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team3647.frc2020.subsystems.Intake;

public class ToggleIntake extends CommandBase {

    private final Intake m_intake;
    private boolean isInnerExtended;
    private boolean isOuterExtended;
  /**
   * Creates a new ToggleIntake.
   */
  public ToggleIntake(Intake intake) {
      m_intake = intake;
      addRequirements(m_intake);
      isInnerExtended = m_intake.isInnerExtended();
      isOuterExtended = m_intake.isOuterExtended();
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    isInnerExtended = m_intake.isInnerExtended();
    isOuterExtended = m_intake.isOuterExtended();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!isInnerExtended){
      m_intake.extendInner();
      try {
		wait(300);
	    } catch (InterruptedException e) {

		e.printStackTrace();
        };
    }
      if (isOuterExtended){
        m_intake.retractOuter();
      } else {
        m_intake.extendOuter();
      }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
