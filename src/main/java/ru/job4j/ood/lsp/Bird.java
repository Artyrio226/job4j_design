package ru.job4j.ood.lsp;

public class Bird {

    public void fly() {
        System.out.println("I am flying.");
    }
}

class Ostrich extends Bird {

    /* У наследника нарушен инвариант базового класса. */
    public void fly() {
        throw new UnsupportedOperationException("I can't fly.");
    }
}