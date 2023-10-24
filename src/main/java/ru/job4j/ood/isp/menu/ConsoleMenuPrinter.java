package ru.job4j.ood.isp.menu;

import ru.job4j.ood.isp.menu.todoapp.Output;

public class ConsoleMenuPrinter implements MenuPrinter {

    Output out;

    public ConsoleMenuPrinter(Output out) {
        this.out = out;
    }

    @Override
    public void print(Menu menu) {
        menu.forEach(i -> out.println(retreat(i.getNumber()) + i.getNumber() + i.getName()));
    }

    private static String retreat(String str) {
        int dotsCount = str.split("\\.").length - 1;
        String sj = "";
        for (int j = 0; j < dotsCount; j++) {
            sj = sj.concat("____");
        }
        return sj;
    }
}
