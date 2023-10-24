package ru.job4j.ood.dip.storage;

import ru.job4j.ood.lsp.storage.Store;
import ru.job4j.ood.lsp.storage.food.Food;

import java.util.ArrayList;
import java.util.List;

public class ControlQualityDIP {
    private final List<Store> storages;

    public ControlQualityDIP(List<Store> storages) {
        this.storages = storages;
    }

    public void distribute(Food product) {
        for (Store store: storages) {
            store.addProduct(product);
        }
    }

    public void resort() {
        List<Food> all = new ArrayList<>();
        for (Store store: storages) {
            all.addAll(store.findAll());
            store.clear();
        }
        for (Store store: storages) {
            all.forEach(store::addProduct);
        }
    }
}
