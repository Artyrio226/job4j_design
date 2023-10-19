package ru.job4j.ood.lsp.parking;

import java.util.List;

public class Parking {
    private final int parkingForTruckSize;
    private final int parkingForPassengerCarSize;
    private int leftPassengerCarSize;
    private int leftTruckSize;
    private final Car[] carList;

    public Parking(int parkingForPassengerCarSize, int parkingForTruckSize) {
        this.parkingForTruckSize = parkingForTruckSize;
        leftTruckSize = parkingForTruckSize;
        this.parkingForPassengerCarSize = parkingForPassengerCarSize;
        leftPassengerCarSize = parkingForPassengerCarSize;
        carList = new Car[parkingForPassengerCarSize + parkingForTruckSize];
    }

    public void add(Car car) {

    }

    public void remove(int id) {

    }

    public Car findById(int id) {
        return null;
    }

    public Car findByOwner(String owner) {
        return null;
    }

    public List<Car> findAll() {
        return null;
    }

    public int getParkingForTruckSize() {
        return parkingForTruckSize;
    }

    public int getParkingForPassengerCarSize() {
        return parkingForPassengerCarSize;
    }

    public int getLeftPassengerCarSize() {
        return leftPassengerCarSize;
    }

    public void setLeftPassengerCarSize(int leftPassengerCarSize) {
        this.leftPassengerCarSize = leftPassengerCarSize;
    }

    public int getLeftTruckSize() {
        return leftTruckSize;
    }

    public void setLeftTruckSize(int leftTruckSize) {
        this.leftTruckSize = leftTruckSize;
    }

    public Car[] getCarList() {
        return carList;
    }
}
