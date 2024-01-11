package de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.motion.data.mileage;

import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.motion.data.mileage.Mileage;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.motion.data.mileage.MileageUnit;

import java.util.Comparator;

public class MileageComparator implements Comparator<Mileage> {
    @Override
    public int compare(Mileage o1, Mileage o2) {
        double valueo1 = harmonizeToKilometre(o1);
        double valueo2 = harmonizeToKilometre(o2);
        if(valueo1 > valueo2)
            return 1;
        else if(valueo1 < valueo2)
            return -1;
        else
            return 0;
    }
    private double harmonizeToKilometre(Mileage mileage) {
        if(mileage.mileageUnit() == MileageUnit.MILES)
            return mileage.mileageValue().value() * 1.60934;
        else
            return mileage.mileageValue().value();
    }

}
