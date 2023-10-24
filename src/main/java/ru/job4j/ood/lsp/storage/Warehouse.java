package ru.job4j.ood.lsp.storage;

import ru.job4j.ood.lsp.storage.food.Food;

import java.util.List;

public class Warehouse extends AbstractStore {

    public Warehouse() {
        super();
    }

    public Warehouse(List<Food> list) {
        super(list);
    }

    @Override
    public void addProduct(Food product) {
        if (product.getFreshness() > 0.75) {
            super.addProduct(product);
        }
    }
}
