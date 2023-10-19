package ru.job4j.ood.lsp.parking;

public class CarParkingService {

    Parking parking;

    public CarParkingService(Parking parking) {
        this.parking = parking;
    }

    public void addCar(Car car) {
        parking.add(car);
    }

    public int getTruckPlaces() {
        return parking.getLeftTruckSize();
    }

    public int getPassengerCarPlaces() {
        return parking.getLeftPassengerCarSize();
    }

    public void removeCar(int id) {
        parking.remove(id);
    }
}
