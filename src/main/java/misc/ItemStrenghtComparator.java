package misc;

import models.Item;
import models.Tank;
import org.apache.commons.lang3.builder.CompareToBuilder;

import java.util.Comparator;

public class ItemStrenghtComparator implements Comparator<Tank> {
    public int compare(Tank a, Tank b) {
        return new CompareToBuilder()
                    .append(a.getCapacity(), b.getCapacity())
                    .append(a.getId(), b.getId())
                                .toComparison();
                    }
}
