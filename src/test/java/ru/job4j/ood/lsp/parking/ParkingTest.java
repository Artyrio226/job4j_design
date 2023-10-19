package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ParkingTest {

    private Parking parking;
    Car t1 = new Truck(3, "KAMAZ", "Zenin Igor");
    Car t2 = new Truck(2, "Ural", "Petrov Oleg");
    Car t3 = new PassengerCar(1, "Mersedes", "Mamina Eva");

    @BeforeEach
    void initData() {
        parking = new Parking(2, 7);
        parking.add(t1);
        parking.add(t2);
        parking.add(t3);
    }

    @Test
    public void whenAddNewCar() {
        Car t4 = new PassengerCar(1, "BMW", "Rogozin Egor");
        parking.add(t4);
        assertThat(parking.findAll()).contains(t1, t2, t3, t4);
    }

    @Test
    public void whenAddNewCarThenException() {
        Car t4 = new PassengerCar(1, "BMW", "Rogozin Egor");
        Car t5 = new PassengerCar(1, "Moskvich", "Isaev Anton");
        parking.add(t4);
        assertThatThrownBy(() -> parking.add(t5))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("No places.");
    }

    @Test
    public void whenFindById() {
        Car result = parking.findById(t3.getId());
        assertThat(result).isEqualTo(t3);
    }

    @Test
    public void whenFindAll() {
        List<Car> result = parking.findAll();
        assertThat(result).hasSize(3)
                .contains(t1)
                .contains(t3)
                .contains(t2);
    }

    @Test
    public void whenFindByOwner() {
        Car result = parking.findByOwner(t2.getOwner());
        assertThat(result).isEqualTo(t2);
    }

    @Test
    public void whenRemoveCar() {
        parking.remove(t3.getId());
        assertThat(parking.findById(t3.getId())).isNull();
    }
}