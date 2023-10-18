package ru.job4j.ood.lsp.storage;

import ru.job4j.ood.lsp.storage.food.Food;

import java.util.List;

public class ControlQuality {
    private final List<Store> storages;

    public ControlQuality(List<Store> storages) {
        this.storages = storages;
    }

    public void distribute(Food product) {
        for (Store store: storages) {
            store.addProduct(product);
        }
    }
}
