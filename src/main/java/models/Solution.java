package models;

import org.optaplanner.core.api.domain.solution.*;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardmediumsoft.HardMediumSoftScore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@PlanningSolution
public class Solution {
    private int id;

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "tankRange")
    private List<Tank> tanks;

    @PlanningEntityCollectionProperty
    private List<Item> items;

    @PlanningScore
    private HardMediumSoftScore score;

    public Solution() {};

    public Solution(int id, List<Tank> tanks, List<Item> items) {
        this.id = id;
        this.tanks = tanks;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Tank> getTanks() {
        return tanks;
    }

    public void setTanks(List<Tank> tanks) {
        this.tanks = tanks;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static Solution generateDemoData() {
        Random rand = new Random();
        List<Tank> tankList = new ArrayList<>(2);
        int tankId = 0;
        tankList.add(new Tank(tankId++, 10000));
        tankList.add(new Tank(tankId++, 5000));
        tankList.add(new Tank(tankId++, 10000));
        tankList.add(new Tank(tankId++, 10000));
        tankList.add(new Tank(tankId++, 10000));
        tankList.add(new Tank(tankId++, 10000));
        tankList.add(new Tank(tankId++, 10000));
        tankList.add(new Tank(tankId++, 7000));
        tankList.add(new Tank(tankId++, 7000));
        tankList.add(new Tank(tankId++, 10000));

        List<Item> itemList = new ArrayList<>(1000);
        for (int i = 0; i < 12500; i++) {
            itemList.add(new Item(i, null, rand.nextInt(1, 14), rand.nextInt(0, 9)));
        }

        return new Solution(0, tankList, itemList);
    }

    public HardMediumSoftScore getScore() {
        return score;
    }

}
