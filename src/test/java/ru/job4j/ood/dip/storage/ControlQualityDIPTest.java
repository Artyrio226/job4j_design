package ru.job4j.ood.dip.storage;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.storage.Shop;
import ru.job4j.ood.lsp.storage.Store;
import ru.job4j.ood.lsp.storage.Trash;
import ru.job4j.ood.lsp.storage.Warehouse;
import ru.job4j.ood.lsp.storage.food.Apple;
import ru.job4j.ood.lsp.storage.food.Potato;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityDIPTest {
    Apple a1 = new Apple("A1", 23.4, "13-07-2023", "15-11-2023");
    Apple a2 = new Apple("A2", 23.4, "13-10-2023", "22-10-2023");
    Potato p1 = new Potato("P1", 18.7, "22-10-2023", "25-11-2023");

    Store trash = new Trash();
    Store shop = new Shop();
    Store warehouse = new Warehouse(new ArrayList<>(List.of(a1, a2, p1)));

    List<Store> store = List.of(
            trash,
            shop,
            warehouse
    );

    ControlQualityDIP controlQuality = new ControlQualityDIP(store);

    @Test
    void checkResort() {
        controlQuality.resort();
        assertThat(warehouse.findAll()).hasSize(1)
                .contains(p1);
        assertThat(shop.findAll()).hasSize(1)
                .contains(a1);
        assertThat(trash.findAll()).hasSize(1)
                .contains(a2);
    }
}