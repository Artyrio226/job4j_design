package ru.job4j.ood.lsp.storage;

import ru.job4j.ood.lsp.storage.food.Food;

public class Trash extends AbstractStore {

    @Override
    public void addProduct(Food product) {
        if (product.getFreshness() <= 0) {
            super.addProduct(product);
        }
    }
}
