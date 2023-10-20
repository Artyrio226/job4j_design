package ru.job4j.ood.lsp.storage;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.storage.food.Apple;
import ru.job4j.ood.lsp.storage.food.Food;
import ru.job4j.ood.lsp.storage.food.Potato;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Disabled
class TrashTest {

    Apple a1 = new Apple("A1", 23.4, "13-07-2023", "15-10-2023");
    Apple a2 = new Apple("A2", 17.8, "13-08-2023", "17-10-2023");
    Potato a3 = new Potato("A3", 29.1, "19-07-2023", "16-10-2023");


    @Test
    public void whenAddNewProduct() {
        Store trash = new Trash();
        trash.addProduct(a1);
        trash.addProduct(a2);
        trash.addProduct(a3);
        trash.addProduct(a1);
        assertThat(trash.findAll()).containsExactly(a1, a2, a3, a1);
    }

    @Test
    public void whenTestFindById() {
        Store trash1 = new Trash();
        trash1.addProduct(a1);
        trash1.addProduct(a2);
        assertThat(trash1.findById(a2.getId())).isEqualTo(a2);
    }

    @Test
    public void whenTestFindAll() {
        Store trash2 = new Trash();
        trash2.addProduct(a1);
        trash2.addProduct(a2);
        trash2.addProduct(a3);
        trash2.addProduct(a1);
        List<Food> result = trash2.findAll();
        assertThat(result).hasSize(4)
                .contains(a1)
                .contains(a3)
                .contains(a2);
    }

    @Test
    public void whenTestFindByNameTwoProducts() {
        Store trash3 = new Trash();
        trash3.addProduct(a1);
        trash3.addProduct(a2);
        trash3.addProduct(a3);
        trash3.addProduct(a1);
        List<Food> result = trash3.findByName(a1.getName());
        assertThat(result).hasSize(2)
                .contains(a1);
    }

    @Test
    public void whenDeleteProductIsSuccessful() throws Exception {
        Store trash4 = new Trash();
        trash4.addProduct(a1);
        trash4.addProduct(a2);
        trash4.addProduct(a3);
        trash4.delete(1);
        assertThat(trash4.findById(1)).isNull();
    }

    @Test
    public void whenDeleteProductIsNotSuccessful() throws Exception {
        Store trash5 = new Trash();
        trash5.addProduct(a1);
        trash5.addProduct(a2);
        trash5.addProduct(a3);
        trash5.delete(4);
        assertThat(trash5.findById(a1.getId())).isEqualTo(a1);
    }
}