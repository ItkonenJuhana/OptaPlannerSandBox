package models;

import io.micrometer.core.lang.Nullable;
import misc.ItemDifficultyComparator;
import misc.ItemStrenghtComparator;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity(difficultyComparatorClass = ItemDifficultyComparator.class)
public class Item {
    @PlanningId
    private int id;
    @PlanningVariable(valueRangeProviderRefs = "tankRange", strengthComparatorClass = ItemStrenghtComparator.class)
    @Nullable
    private Tank assignedTank;
    private Integer qty;

    private Integer tankType;

    public Item() {};

    public Item(int id, Tank assignedTank, Integer qty, Integer tankType) {
        this.id = id;
        this.assignedTank = assignedTank;
        this.qty = qty;
        this.tankType = tankType;
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

    public Integer getTankType() {
        return tankType;
    }

    public void setTankType(Integer tankType) {
        this.tankType = tankType;
    }
}
