package de.arkem.clean.arc.demo.app.vehicle.domain.model;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.mileage.record.Mileage;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.mileage.record.MileageRecord;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.mileage.record.RecordDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Vehicle {
    private final Vin vin;
    private final LicensePlate licensePlate;
    private List<MileageRecord> mileageRecords;

    private Vehicle(Vin vin, LicensePlate licensePlate) {
        this.vin = vin;
        this.licensePlate = licensePlate;
    }

    /**
     * Constructor um ein neues Fahrzeug im Kontext des Anwendungsfall Fahrzeuganlegen
     *
     * @param vin
     * @param licensePlate
     * @param mileage
     */
    public Vehicle(Vin vin, LicensePlate licensePlate, Mileage mileage) {
        this(vin, licensePlate);
        this.mileageRecords = new ArrayList<>();
        validateMandatoryData(vin, licensePlate, mileage);
    }

    /**
     * Constructor um ein neues Fahrzeug im Kontext des Anwendungsfall Fahrzeug lesen
     *
     * @param vin
     * @param licensePlate
     * @param mileageRecords
     */
    public Vehicle(Vin vin, LicensePlate licensePlate, List<MileageRecord> mileageRecords) {
        this(vin, licensePlate);
        this.mileageRecords = mileageRecords;
    }

    /**
     * Static Factory Methode um ein neues Fahrzeug zu erstellen, oft ein aussagekräftigere und
     * flexiblere Alternative zu einem Konstruktor
     *
     * @param vin
     * @param licensePlate
     * @param mileage
     * @return
     */
    public static Vehicle createNewVehicle(Vin vin, LicensePlate licensePlate, Mileage mileage) {
        Vehicle vehicle = new Vehicle(vin, licensePlate);
        vehicle.mileageRecords = new ArrayList<>();
        vehicle.mileageRecords.add(new MileageRecord(mileage, new RecordDate(LocalDateTime.now())));
        return vehicle;
    }

    public void updateMileage(Mileage mileage) {
        if (mileage != null && isNewMileageHigherThanThePreviousMileage(mileage)) {
            RecordDate recordDate = new RecordDate(LocalDateTime.now());
            mileageRecords.add(new MileageRecord(mileage, recordDate));
        } else {
            throw new IllegalArgumentException("kilometerstand is not valid");
        }
    }

    public Optional<Mileage> findLatestMileage() {
        MileageRecord latestMileageRecord = mileageRecords.stream()
                .max(Comparator.comparing(mileageRecord -> mileageRecord.recordDate().value()))
                .orElse(null);
        if (latestMileageRecord == null) {
            return Optional.empty();
        }
        return Optional.of(latestMileageRecord.mileage());
    }

    public Vin getVin() {
        return vin;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public List<MileageRecord> getMileageRecords() {
        return mileageRecords;
    }

    private boolean isNewMileageHigherThanThePreviousMileage(Mileage mileage) {
        Optional<Mileage> latestMileageRecord = findLatestMileage();
        if (latestMileageRecord.isEmpty()) {
            return true;
        } else {
            if (latestMileageRecord.get().value() <= mileage.value()) {
                return true;
            }
        }
        return false;
    }

    private void validateMandatoryData(Vin vin, LicensePlate licensePlate, Mileage mileage) {
        if (vin == null || licensePlate == null || mileage == null) {
            throw new IllegalArgumentException("vehicle is not valid");
        }
    }
}