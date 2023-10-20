package ru.job4j.ood.lsp.storage;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.storage.food.Apple;
import ru.job4j.ood.lsp.storage.food.Potato;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Disabled
class ControlQualityTest {

    Store trash = new Trash();
    Store shop = new Shop();
    Store warehouse = new Warehouse();

    List<Store> store = List.of(
            trash,
            shop,
            warehouse
    );

    @Test
    void checkTrash() {
        ControlQuality controlQuality = new ControlQuality(store);
        Apple a1 = new Apple("A1", 23.4, "13-07-2023", "15-10-2023");
        controlQuality.distribute(new Apple("A1", 23.4, "13-07-2023", "15-10-2023"));
        assertThat(trash.findAll()).hasSize(1)
                .contains(a1);
    }

    @Test
    void checkShop() {
        ControlQuality controlQuality = new ControlQuality(store);
        Apple a1 = new Apple("A1", 23.4, "13-07-2023", "25-10-2023");
        a1.setDiscount(20);
        controlQuality.distribute(new Apple("A1", 23.4, "13-07-2023", "25-10-2023"));
        assertThat(shop.findAll()).hasSize(1)
                .contains(a1);
    }

    @Test
    void checkWarehouse() {
        ControlQuality controlQuality = new ControlQuality(store);
        Potato a1 = new Potato("A1", 23.4, "13-10-2023", "25-11-2023");
        controlQuality.distribute(new Potato("A1", 23.4, "13-10-2023", "25-11-2023"));
        assertThat(warehouse.findAll()).hasSize(1)
                .contains(a1);
    }
}