package misc;

import models.Item;
import org.optaplanner.core.api.score.buildin.hardmediumsoft.HardMediumSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintCollectors;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;


public class BinPackingConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
                // Hard constraints
                capacityConflict(constraintFactory),
                // Medium constraints
                usedTankPenalty(constraintFactory),
                wrongTankPenalty(constraintFactory)
        };
    }

    private Constraint capacityConflict(ConstraintFactory constraintFactory) {
        return constraintFactory.forEach(Item.class)
                .groupBy(Item::getAssignedTank, ConstraintCollectors.sum(Item::getQty))
                .filter((tank, qty) -> tank.getCapacity() < qty)
                .penalize(
                        "Capacity conflict",
                        HardMediumSoftScore.ONE_HARD,
                        (tank, qty) -> qty - tank.getCapacity());
    }

    private Constraint usedTankPenalty(ConstraintFactory constraintFactory) {
        return constraintFactory.forEach(Item.class)
                .groupBy(Item::getAssignedTank)
                .penalize("Used tank penalty", HardMediumSoftScore.ONE_MEDIUM);
    }

    private Constraint wrongTankPenalty(ConstraintFactory constraintFactory) {
        return constraintFactory.forEach(Item.class)
                .filter(item -> !item.getTankType().equals(item.getAssignedTank().getId()))
                .penalize("Wrong tank penalty", HardMediumSoftScore.ONE_MEDIUM);
    }
}