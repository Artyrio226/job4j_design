package ru.job4j.ood.lsp.parking;

public class Truck extends Car {
    public Truck(int size, String model, String owner) {
        super(Math.max(size, 2), model, owner);
    }
}
