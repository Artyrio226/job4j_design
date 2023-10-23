package ru.job4j.ood.isp.menu.todoapp;

import ru.job4j.ood.isp.menu.Menu;

public class CreateChild implements UserAction {
    private final Output out;

    public CreateChild(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add child menu Item";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        out.println("=== Create a new child Item ===");
        String parent = input.askStr("Enter name for parent menu item: ");
        if (menu.select(parent).isEmpty()) {
            out.println("Invalid name. Please try again.");
        } else {
            String nameParent = menu.select(parent).get().getName();
            String name = input.askStr("Enter name for child menu item: ");
            String act = input.askStr("Enter action: ");
            menu.add(nameParent, name, new DefaultAction(act));
        }
        return true;
    }
}