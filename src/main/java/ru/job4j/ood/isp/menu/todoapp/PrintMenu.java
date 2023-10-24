package ru.job4j.ood.isp.menu.todoapp;

import ru.job4j.ood.isp.menu.ConsoleMenuPrinter;
import ru.job4j.ood.isp.menu.Menu;
import ru.job4j.ood.isp.menu.MenuPrinter;

public class PrintMenu implements UserAction {

    private final Output out;

    public PrintMenu(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Print menu";
    }

    @Override
    public boolean execute(Input input, Menu menu) {
        MenuPrinter printer = new ConsoleMenuPrinter(out);
        printer.print(menu);
        return true;
    }
}
