package ru.job4j.ood.dip;

public class Workshop {

    /*
     * Всё сильно связано. Метод зависит от двух конкретных классов.
     * Нужно ослабить зависимости. Создать абстракции Material и Masterpiece.
     * И использовать эти абстракции.
     */
    public Sculpture createMasterpiece(Granite granite) {
        return new Sculpture(granite);
    }
}

class Sculpture {

    Granite granite;

    public Sculpture(Granite granite) {
        this.granite = granite;
    }
}

class Granite {

}