package ru.job4j.ood.dip;

public class Truck {

    private WheelsBridgestone wheels;

    /*
     * Класс жёстко зависит от конкретных колёс.
     * Чтобы разорвать зависимость
     * нужно, например, создать абстракцию Wheels, от неё реализовать
     * разные колёса. Испопльзовать их уже через абстракцию.
     */
    public Truck(WheelsBridgestone wheels) {
        this.wheels = wheels;
    }
}

class WheelsBridgestone {

    private int radius;
}