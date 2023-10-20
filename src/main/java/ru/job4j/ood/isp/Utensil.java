package ru.job4j.ood.isp;

public interface Utensil {

    /* например сковородке для блинов нужно только "жарить" - нарушение isp */
    void roast();  /* жарить */
    void warmUp();  /* подогревать */
    void boil();  /* варить */
    void stew();  /* тушить */
}
