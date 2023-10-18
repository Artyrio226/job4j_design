package ru.job4j.ood.lsp.storage;

import ru.job4j.ood.lsp.storage.food.Food;

public class Warehouse extends AbstractStore {

    @Override
    public void addProduct(Food product) {
        if (product.getFreshness() > 0.75) {
            super.addProduct(product);
        }
    }
}
