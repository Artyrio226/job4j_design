package ru.job4j.ood.lsp.storage;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.storage.food.Apple;
import ru.job4j.ood.lsp.storage.food.Food;
import ru.job4j.ood.lsp.storage.food.Potato;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Disabled
class WarehouseTest {

    Apple a1 = new Apple("A1", 23.4, "13-10-2023", "15-11-2023");
    Apple a2 = new Apple("A2", 17.8, "10-10-2023", "17-11-2023");
    Potato a3 = new Potato("A3", 29.1, "15-10-2023", "16-12-2023");


    @Test
    public void whenAddNewProduct() {
        Store warehouse = new Warehouse();
        warehouse.addProduct(a1);
        warehouse.addProduct(a2);
        warehouse.addProduct(a3);
        warehouse.addProduct(a1);
        assertThat(warehouse.findAll()).containsExactly(a1, a2, a3, a1);
    }

    @Test
    public void whenTestFindById() {
        Store warehouse1 = new Warehouse();
        warehouse1.addProduct(a1);
        warehouse1.addProduct(a2);
        assertThat(warehouse1.findById(a2.getId())).isEqualTo(a2);
    }

    @Test
    public void whenTestFindAll() {
        Store warehouse2 = new Warehouse();
        warehouse2.addProduct(a1);
        warehouse2.addProduct(a2);
        warehouse2.addProduct(a3);
        warehouse2.addProduct(a1);
        List<Food> result = warehouse2.findAll();
        assertThat(result).hasSize(4)
                .contains(a1)
                .contains(a3)
                .contains(a2);
    }

    @Test
    public void whenTestFindByNameTwoProducts() {
        Store warehouse3 = new Warehouse();
        warehouse3.addProduct(a1);
        warehouse3.addProduct(a2);
        warehouse3.addProduct(a3);
        warehouse3.addProduct(a1);
        List<Food> result = warehouse3.findByName(a1.getName());
        assertThat(result).hasSize(2)
                .contains(a1);
    }

    @Test
    public void whenDeleteProductIsSuccessful() throws Exception {
        Store warehouse4 = new Warehouse();
        warehouse4.addProduct(a1);
        warehouse4.addProduct(a2);
        warehouse4.addProduct(a3);
        warehouse4.delete(1);
        assertThat(warehouse4.findById(1)).isNull();
    }

    @Test
    public void whenDeleteProductIsNotSuccessful() throws Exception {
        Store warehouse5 = new Warehouse();
        warehouse5.addProduct(a1);
        warehouse5.addProduct(a2);
        warehouse5.addProduct(a3);
        warehouse5.delete(4);
        assertThat(warehouse5.findById(a1.getId())).isEqualTo(a1);
    }
}