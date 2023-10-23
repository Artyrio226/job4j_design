package ru.job4j.ood.isp.menu.todoapp;

import ru.job4j.ood.isp.menu.Menu;

public class CreateRoot implements UserAction {
    private final Output out;

    public CreateRoot(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add root menu Item";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        out.println("=== Create a new root Item ===");
        String name = input.askStr("Enter name for root menu item: ");
        String act = input.askStr("Enter action: ");
        menu.add(Menu.ROOT, name, new DefaultAction(act));
        return true;
    }
}