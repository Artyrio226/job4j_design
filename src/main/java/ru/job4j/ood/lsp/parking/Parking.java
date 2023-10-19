package ru.job4j.ood.lsp.parking;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Parking {
    private static int carListSize;
    private final int parkingForTruckSize;
    private final int parkingForPassengerCarSize;
    private int leftPassengerCarSize;
    private int leftTruckSize;
    private final Car[] carList;

    public Parking(int parkingForPassengerCarSize, int parkingForTruckSize) {
        carListSize = parkingForPassengerCarSize + parkingForTruckSize;
        this.parkingForTruckSize = parkingForTruckSize;
        leftTruckSize = parkingForTruckSize;
        this.parkingForPassengerCarSize = parkingForPassengerCarSize;
        leftPassengerCarSize = parkingForPassengerCarSize;
        carList = new Car[carListSize];
    }

    public void add(Car car) {
        int carSize = car.getSize();
        if (leftTruckSize == 0 && leftPassengerCarSize < carSize) {
            throw new IndexOutOfBoundsException("No places.");
        }
        boolean flag = false;
        if (carSize > 1 && leftTruckSize > 0) {
            for (int i = parkingForPassengerCarSize; i < carListSize; i++) {
                if (carList[i] == null) {
                    carList[i] = car;
                    leftTruckSize--;
                    flag = true;
                    break;
                }
            }
        } else if (carSize > 1 && leftPassengerCarSize >= carSize) {
            int length = 0;
            for (int i = 0; i < parkingForPassengerCarSize; i++) {
                if (carList[i] == null) {
                    length++;
                    if (length == carSize) {
                        for (int j = i - (carSize - 1); j < carSize + i - 1; j++) {
                            carList[j] = car;
                            leftPassengerCarSize--;
                        }
                        flag = true;
                        break;
                    }
                } else {
                    length = 0;
                }
            }
        }
        if (car.getSize() == 1 && leftPassengerCarSize > 0) {
            for (int i = 0; i < parkingForPassengerCarSize; i++) {
                if (carList[i] == null) {
                    carList[i] = car;
                    leftPassengerCarSize--;
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) {
            throw new IndexOutOfBoundsException("No places.");
        }
    }

    public void remove(int id) {
        for (int i = 0; i < carListSize; i++) {
            if (carList[i] != null && carList[i].getId() == id) {
                carList[i] = null;
            }
        }
    }

    public Car findById(int id) {
        Optional<Car> car = Arrays.stream(carList)
                .filter(Objects::nonNull)
                .filter(c -> c.getId() == id)
                .findFirst();
        return car.orElse(null);
    }

    public Car findByOwner(String owner) {
        Optional<Car> car = Arrays.stream(carList)
                                  .filter(Objects::nonNull)
                                  .filter(c -> owner.equals(c.getOwner()))
                                  .findFirst();
        return car.orElse(null);
    }

    public List<Car> findAll() {
        return Arrays.stream(carList).filter(Objects::nonNull).toList();
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

    public int getLeftTruckSize() {
        return leftTruckSize;
    }

    public Car[] getCarList() {
        return carList;
    }
}
