package models;

import io.micrometer.core.lang.Nullable;
import misc.ItemDifficultyComparator;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity(difficultyComparatorClass = ItemDifficultyComparator.class)
public class Item {
    @PlanningId
    private int id;
    @PlanningVariable(valueRangeProviderRefs = "tankRange")
    @Nullable
    private Tank assignedTank;
    private Integer qty;

    public Item() {};

    public Item(int id, Tank assignedTank, Integer qty) {
        this.id = id;
        this.assignedTank = assignedTank;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Tank getAssignedTank() {
        return assignedTank;
    }

    public void setAssignedTank(Tank assignedTank) {
        this.assignedTank = assignedTank;
    }
}
