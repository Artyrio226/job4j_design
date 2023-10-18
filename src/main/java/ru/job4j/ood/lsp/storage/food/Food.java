package ru.job4j.ood.lsp.storage.food;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Food {
    private static int counter = 1;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final int id;
    protected String name;
    protected LocalDate createDate;
    protected LocalDate expiryDate;
    protected double price;
    protected int discount;
    protected double freshness;

    public Food(String name, double price, String createDate, String expiryDate) {
        id = counter;
        counter++;
        this.name = name;
        setCreateDate(createDate);
        setExpiryDate(expiryDate);
        setFreshness(this.createDate, this.expiryDate);
        setPrice(price);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = round(price - (price / 100) * discount);
    }

    public double getPrice() {
        return price;
    }

    public double getFreshness() {
        return freshness;
    }

    private void setCreateDate(String date) {
        this.createDate = LocalDate.parse(date, FORMATTER);
    }

    private void setExpiryDate(String date) {
        this.expiryDate = LocalDate.parse(date, FORMATTER);
    }

    public void setDiscount(int discount) {
        this.discount = discount;
        setPrice(getPrice());
    }

    private void setFreshness(LocalDate createDate, LocalDate expiryDate) {
        long allDays = Duration.between(createDate.atStartOfDay(), expiryDate.atStartOfDay()).toDays();
        long leftDays = Duration.between(LocalDate.now().atStartOfDay(), expiryDate.atStartOfDay()).toDays();
        freshness = round((leftDays * 1.0) / allDays);
    }

    private double round(double num) {
        return (double) Math.round(num * 100) / 100;
    }

    @Override
    public String toString() {
        return "Food{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", createDate=" + createDate
                + ", expiryDate=" + expiryDate
                + ", price=" + price
                + ", discount=" + discount
                + ", freshness=" + freshness
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Double.compare(food.price, price) == 0 && discount == food.discount && Double.compare(food.freshness, freshness) == 0 && Objects.equals(name, food.name) && Objects.equals(createDate, food.createDate) && Objects.equals(expiryDate, food.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createDate, expiryDate, price, discount, freshness);
    }
}
