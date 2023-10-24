package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.isp.menu.todoapp.Output;
import ru.job4j.ood.isp.menu.todoapp.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleMenuPrinterTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenPrint() {
        Output out = new StubOutput();
        ConsoleMenuPrinter printer = new ConsoleMenuPrinter(out);
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        printer.print(menu);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
        "1.Сходить в магазин" + ln
        + "____1.1.Купить продукты" + ln
        + "________1.1.1.Купить хлеб" + ln
        + "________1.1.2.Купить молоко" + ln
        + "2.Покормить собаку" + ln
        );
    }
}