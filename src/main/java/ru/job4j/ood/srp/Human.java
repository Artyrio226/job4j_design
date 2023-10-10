package ru.job4j.ood.srp;

public class Human {
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
     * Класс Human отвечает за хранение данных.
     * Функционал нужно вынести в отдельный класс или интерфейс.
     * Человек может и не уметь ходить на руках.
     */
    public void walkOnHands() {
    }
}
