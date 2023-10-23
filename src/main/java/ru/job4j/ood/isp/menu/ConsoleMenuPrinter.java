package ru.job4j.ood.isp.menu;

public class ConsoleMenuPrinter implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        menu.forEach(i -> System.out.println(retreat(i.getNumber()) + i.getNumber() + i.getName()));
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
