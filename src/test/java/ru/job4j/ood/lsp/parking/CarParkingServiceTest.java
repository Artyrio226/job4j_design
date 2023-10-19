package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Disabled
class CarParkingServiceTest {

    @Test
    void whenAddTruckThenTruckPlaces() {
        Parking parking = new Parking(7, 5);
        CarParkingService service = new CarParkingService(parking);
        Car t1 = new Truck(3, "KAMAZ", "Zenin Igor");
        service.addCar(t1);
        assertThat(parking.getTruckPlaces()).isEqualTo(4);
    }

    @Test
    void whenAddTruckThenPassengerCarPlaces() {
        Parking parking = new Parking(7, 0);
        CarParkingService service = new CarParkingService(parking);
        Car t1 = new Truck(2, "KAMAZ", "Zenin Igor");
        service.addCar(t1);
        assertThat(parking.getPassengerCarPlaces()).isEqualTo(5);
    }

    @Test
    void whenAddPassengerCar() {
        Parking parking = new Parking(7, 5);
        CarParkingService service = new CarParkingService(parking);
        Car p1 = new PassengerCar(1, "Lada", "Savina Elena");
        service.addCar(p1);
        assertThat(parking.getPassengerCarPlaces()).isEqualTo(6);
    }

    @Test
    void whenAddTruckThenException() {
        Parking parking = new Parking(7, 5);
        CarParkingService service = new CarParkingService(parking);
        Car t1 = new Truck(3, "KAMAZ", "Zenin Igor");
        service.addCar(t1);
        assertThatThrownBy(() -> service.addCar(t1))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("No places.");
    }

    @Test
    void whenRemoveById() {
        Parking parking = new Parking(7, 5);
        CarParkingService service = new CarParkingService(parking);
        Car t1 = new Truck(3, "KAMAZ", "Zenin Igor");
        Car t2 = new Truck(2, "Ural", "Petrov Oleg");
        Car t3 = new Truck(4, "ZiL", "Sidorov Roman");
        service.addCar(t1);
        service.addCar(t2);
        service.addCar(t3);
        service.removeCar(t3.getId());
        assertThat(parking.findById(t3.getId())).isNull();
    }
}