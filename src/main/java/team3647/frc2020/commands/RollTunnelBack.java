package team3647.frc2020.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team3647.frc2020.subsystems.Indexer;
import team3647.frc2020.subsystems.KickerWheel;
import team3647.lib.IndexerSignal;

public class RollTunnelBack extends CommandBase {
    private final Indexer m_indexer;
    private final KickerWheel m_kickerwheel;

    /**
     * Creates a new IndexerManual.
     */
    public RollTunnelBack(Indexer indexer, KickerWheel kickerwheel) {
        m_indexer = indexer;
        m_kickerwheel = kickerwheel;

        addRequirements(m_indexer, kickerwheel);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double output = -0.1;
        m_indexer.set(new IndexerSignal(Math.signum(output), Math.signum(output) * .8, output, output));
        m_kickerwheel.setOpenloop(-0.7);
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
