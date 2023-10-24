package ru.job4j.ood.dip;

public class Conveyor {

    /*
     * Метод зависит от конкретного класса.
     * Если захотим собрать другой телефон, без созданию ещё одного методане обойтись.
     * Нужно создать абстракцию Phone, от неё реализовать
     * разные телефоны. Возвращать из метода абстракцию.
     */
    public Iphone assembling(double diagonal) {
        return new Iphone(diagonal);
    }
}

class Iphone {

    double diagonal;

    public Iphone(double diagonal) {
        this.diagonal = diagonal;
    }
}