package ru.job4j.ood.lsp.parking;

public abstract class Car {
    private static int counter = 1;
    private final int id = counter++;
    private int size;
    private final String model;
    private String owner;

    public Car(int size, String model, String owner) {
        this.size = size;
        this.model = model;
        this.owner = owner;
    }
}
