package ru.job4j.ood.isp.menu.todoapp;

public class ConsoleOutput implements Output {
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}
