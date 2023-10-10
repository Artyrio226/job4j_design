package ru.job4j.ood.srp;

public class Amount {

    /*
     * Метод выполняет несколько функций.
     * Происходит суммирование двух чисел и вывод суммы на экран.
     * Метод должен иметь только одну четкую функцию. Если метод
     * выполняет несколько задач, это нарушает принцип единственной ответственности.
     */
    public int sumAndPrint(int a, int b) {
        int result = a + b;
        System.out.println("Сумма: " + result);
        return result;
    }
}
