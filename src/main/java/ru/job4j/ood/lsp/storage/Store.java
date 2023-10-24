package ru.job4j.ood.lsp.storage;

import ru.job4j.ood.lsp.storage.food.Food;

import java.util.List;

public interface Store {

    void addProduct(Food product);

    void delete(int id) throws Exception;

    List<Food> findAll();

    List<Food> findByName(String key);

    Food findById(int id);

    void clear();
}
