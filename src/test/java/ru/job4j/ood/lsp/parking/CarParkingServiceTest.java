package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Disabled
class CarParkingServiceTest {

    Parking parking;
    CarParkingService service;
    Car t1 = new Truck(3, "KAMAZ", "Zenin Igor");
    Car t2 = new Truck(2, "Ural", "Petrov Oleg");
    Car t3 = new PassengerCar(1, "Mersedes", "Mamina Eva");

    @BeforeEach
    void initData() {
        parking = new Parking(4, 2);
        service = new CarParkingService(parking);
        parking.add(t1);
        parking.add(t2);
        parking.add(t3);
    }

    @Test
    void whenAddTruckThenTruckPlaces() {
        Car t1 = new Truck(3, "KAMAZ", "Zenin Igor");
        service.addCar(t1);
        assertThat(service.getTruckPlaces()).isEqualTo(0);
    }

    @Test
    void whenAddTruckThenPassengerCarPlaces() {
        Car t1 = new Truck(2, "KAMAZ", "Zenin Igor");
        service.addCar(t1);
        assertThat(service.getPassengerCarPlaces()).isEqualTo(1);
    }

    @Test
    void whenAddPassengerCar() {
        Car p1 = new PassengerCar(1, "Lada", "Savina Elena");
        service.addCar(p1);
        assertThat(service.getPassengerCarPlaces()).isEqualTo(2);
    }

    @Test
    void whenAddTruckThenException() {
        Car t4 = new Truck(4, "KAMAZ", "Zeninov Igor");
        assertThatThrownBy(() -> service.addCar(t4))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("No places.");
    }

    @Test
    void whenRemoveById() {
        service.removeCar(t3.getId());
        assertThat(parking.findById(t3.getId())).isNull();
    }
}