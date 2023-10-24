package ru.job4j.ood.lsp.storage;

import ru.job4j.ood.lsp.storage.food.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    public final List<Food> products;

    protected AbstractStore() {
        this.products = new ArrayList<>();
    }
    public AbstractStore(List<Food> list) {
        this.products = list;
    }

    public  void addProduct(Food product) {
        products.add(product);
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            products.remove(index);
        }
    }

    public List<Food> findByName(String key) {
        List<Food> rsl = new ArrayList<>();
        for (Food f : products) {
            if (key.equals(f.getName())) {
                rsl.add(f);
            }
        }
        return rsl;
    }

    public List<Food> findAll() {
        return List.copyOf(products);
    }

    public Food findById(int id) {
        int index = indexOf(id);
        return index != -1 ? products.get(index) : null;
    }

    public void clear() {
        products.clear();
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < products.size(); index++) {
            if (products.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}
