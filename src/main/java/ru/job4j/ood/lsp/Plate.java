package ru.job4j.ood.lsp;

public class Plate {
    private double volume;

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        if (volume < 0 || volume > 1.0) {
            throw new IllegalArgumentException("Incorrect volume.");
        }
        this.volume = volume;
    }
}

class Saucer extends Plate {

    public double getVolume() {
        return super.getVolume();
    }

    /* У наследника усилено предусловие в методе. */
    public void setVolume(double volume) {
        if (volume < 0 || volume > 0.5) {
            throw new IllegalArgumentException("Incorrect volume.");
        }
        super.setVolume(volume);
    }
}