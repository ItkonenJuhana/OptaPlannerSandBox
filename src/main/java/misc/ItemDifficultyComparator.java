package misc;

import models.Item;
import org.apache.commons.lang3.builder.CompareToBuilder;

import java.util.Comparator;

public class ItemDifficultyComparator implements Comparator<Item> {
    public int compare(Item a, Item b) {
        return new CompareToBuilder()
                .append(a.getQty(), b.getQty())
                .append(a.getId(), b.getId())
                .toComparison();
    }
}