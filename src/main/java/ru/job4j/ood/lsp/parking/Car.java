package ru.job4j.ood.lsp.parking;

import java.util.Objects;

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

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return id == car.id && size == car.size && Objects.equals(model, car.model) && Objects.equals(owner, car.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size, model, owner);
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id
                + ", size=" + size
                + ", model='" + model + '\''
                + ", owner='" + owner + '\''
                + '}';
    }
}
