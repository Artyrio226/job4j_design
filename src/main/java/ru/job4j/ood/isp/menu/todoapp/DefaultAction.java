package ru.job4j.ood.isp.menu.todoapp;

import ru.job4j.ood.isp.menu.ActionDelegate;

public class DefaultAction implements ActionDelegate {
    String act;

    public DefaultAction(String act) {
        this.act = act;
    }

    @Override
    public void delegate() {
        System.out.println(act);
    }
}
