package ru.job4j.ood.isp;

public interface CookingRecipe {

    /* например для приготовления яичницы многих методов не нужно - нарушение isp */
    void addVegetables();  /* добавить овощи */
    void addFish();  /* добавить рыбу */
    void addMeat();  /* добавить мясо */
    void cutFruit();  /* нарезать фрукты */
    void fryTheEggs();  /* обжарить яйца */
    void addGreens();  /* добавить зелень */
    void peelThePotatoes();  /* почистить картошку */

}
