package ru.job4j.ood.lsp.storage;

import ru.job4j.ood.lsp.storage.food.Food;

import java.util.List;

public class Shop extends AbstractStore {

    public Shop() {
        super();
    }

    public Shop(List<Food> list) {
        super(list);
    }

    @Override
    public void addProduct(Food product) {
        if (product.getFreshness() > 0 && product.getFreshness() <= 0.75) {
            super.addProduct(product);
        }
        if (product.getFreshness() > 0 && product.getFreshness() <= 0.25) {
            product.setDiscount(20);
        }
    }
}
