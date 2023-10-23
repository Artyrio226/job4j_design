package ru.job4j.ood.isp.menu.todoapp;

import ru.job4j.ood.isp.menu.Menu;

public class ExecuteAction implements UserAction {

    private final Output out;

    public ExecuteAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Execute menu Item action";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        out.println("=== Execute menu Item action ===");
        String name = input.askStr("Enter the name menu item: ");
        if (menu.select(name).isEmpty()) {
            out.println("Invalid name. Please try again.");
        } else {
            menu.select(name).get().getActionDelegate().delegate();
        }
        return true;
    }
}
