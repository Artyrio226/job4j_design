package ru.job4j.ood.lsp.storage;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.storage.food.Apple;
import ru.job4j.ood.lsp.storage.food.Food;
import ru.job4j.ood.lsp.storage.food.Potato;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ShopTest {

    Apple a1 = new Apple("A1", 23.4, "13-07-2023", "15-11-2023");
    Apple a2 = new Apple("A2", 17.8, "13-08-2023", "17-11-2023");
    Potato a3 = new Potato("A3", 29.1, "19-07-2023", "16-12-2023");


    @Test
    public void whenAddNewProduct() {
        Store shop = new Shop();
        shop.addProduct(a1);
        shop.addProduct(a2);
        shop.addProduct(a3);
        shop.addProduct(a1);
        assertThat(shop.findAll()).containsExactly(a1, a2, a3, a1);
    }

    @Test
    public void whenTestFindById() {
        Store shop1 = new Shop();
        shop1.addProduct(a1);
        shop1.addProduct(a2);
        assertThat(shop1.findById(a2.getId())).isEqualTo(a2);
    }

    @Test
    public void whenTestFindAll() {
        Store shop2 = new Shop();
        shop2.addProduct(a1);
        shop2.addProduct(a2);
        shop2.addProduct(a3);
        shop2.addProduct(a1);
        List<Food> result = shop2.findAll();
        assertThat(result).hasSize(4)
                .contains(a1)
                .contains(a3)
                .contains(a2);
    }

    @Test
    public void whenTestFindByNameTwoProducts() {
        Store shop3 = new Shop();
        shop3.addProduct(a1);
        shop3.addProduct(a2);
        shop3.addProduct(a3);
        shop3.addProduct(a1);
        List<Food> result = shop3.findByName(a1.getName());
        assertThat(result).hasSize(2)
                .contains(a1);
    }

    @Test
    public void whenDeleteProductIsSuccessful() throws Exception {
        Store shop4 = new Shop();
        shop4.addProduct(a1);
        shop4.addProduct(a2);
        shop4.addProduct(a3);
        shop4.delete(1);
        assertThat(shop4.findById(1)).isNull();
    }

    @Test
    public void whenDeleteProductIsNotSuccessful() throws Exception {
        Store shop5 = new Shop();
        shop5.addProduct(a1);
        shop5.addProduct(a2);
        shop5.addProduct(a3);
        shop5.delete(4);
        assertThat(shop5.findById(a1.getId())).isEqualTo(a1);
    }

    @Test
    public void whenPriceChanged() throws Exception {
        Store shop6 = new Shop();
        Potato a4 = new Potato("A3", 29.1, "19-07-2023", "16-12-2023");
        shop6.addProduct(new Potato("A3", 29.1, "19-07-2023", "16-12-2023"));
        a4.setDiscount(20);
        assertThat(a4.getPrice()).isEqualTo(23.28);
    }
}