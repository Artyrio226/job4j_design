package ru.job4j.ood.srp;

public class Sportsman {

    public Sportsman(Human human) {
    }

    /*
    * Разный функционал в одном классе. Объект должен специализироваться
    * на одной из этих задач. Вместо этого для каждой задачи должны быть
    * созданы отдельные интерфейсы.
    */
    public void runHundredMeters() {
    }

    public void swimHundredMeters() {
    }

    public void playChess() {
    }
}
