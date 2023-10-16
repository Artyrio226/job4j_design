package ru.job4j.ood.lsp;

public class RacingSportsCar {
    private double mileage;

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void addMileage(double distance) {
        mileage += distance;
        if (mileage > 5_000) {
            System.out.println("It's time to do an engine overhaul.");
        }
    }
}

class SerialSportsCar extends RacingSportsCar {
    private double mileage;

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    /* У наследника ослаблено постусловие в методе. */
    public void addMileage(double distance) {
        mileage += distance;
        if (mileage > 500_000) {
            System.out.println("It's time to do an engine overhaul.");
        }
    }
}