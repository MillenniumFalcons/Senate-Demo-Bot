package team3647.frc2020.commands;

import team3647.frc2020.robot.Constants;
import team3647.frc2020.subsystems.BallStopper;
import team3647.frc2020.subsystems.Flywheel;
import team3647.frc2020.subsystems.Indexer;
import team3647.frc2020.subsystems.KickerWheel;
import team3647.lib.IndexerSignal;

public class BatterShot extends ShootClosedLoop {
    /**
     * Creates a new TrenchShot.
     */
    public BatterShot(Flywheel flywheel, KickerWheel kickerWheel, Indexer indexer, BallStopper ballStopper) {
        super(flywheel, kickerWheel, indexer, ballStopper, () -> {
            return 5000;
        }, (c) -> 0.7, IndexerSignal.GO);
        // Use addRequirements() here to declare subsystem dependencies.
    }
}
