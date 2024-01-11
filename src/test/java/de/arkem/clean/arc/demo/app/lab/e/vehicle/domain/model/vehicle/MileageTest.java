package de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileage.Mileage;

class MileageTest {

    public static Comparator<Mileage> mileageComparator = Comparator.comparing(Mileage::getValue);

    public static void main(String[] args) {
        Mileage mileage1 = new Mileage("100 miles");
        Mileage mileage2 = new Mileage("50 miles");
        Mileage mileage3 = new Mileage("200 miles");

        // Using Comparable
        System.out.println(mileage1.compareTo(mileage2)); // Output: 1 (mileage1 > mileage2)

        // Using Comparator
        System.out.println(mileageComparator.compare(mileage1, mileage3)); // Output: -1 (mileage1 < mileage3)
    }

}