package ru.job4j.ood.ocp;

public class FoodShop {

    /*
     * Чтобы продать новый продукт нужно создать новый метод.
     * Понадобится изменять класс. Это нарушает принцип OCP.
     * Например можно сделать один метод sellFood(), который принимает интерфейс Products.
     */
    public void sellApple(double price) {
    }

    public void sellPumpkin(double price) {
    }
}
