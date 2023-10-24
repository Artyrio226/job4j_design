package ru.job4j.ood.lsp.storage;

import ru.job4j.ood.lsp.storage.food.Food;

import java.util.List;

public class Trash extends AbstractStore {

    public Trash() {
        super();
    }

    public Trash(List<Food> list) {
        super(list);
    }

    @Override
    public void addProduct(Food product) {
        if (product.getFreshness() <= 0) {
            super.addProduct(product);
        }
    }
}
