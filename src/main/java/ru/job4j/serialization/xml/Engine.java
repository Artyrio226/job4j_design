package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "engine")
public class Engine {
    @XmlAttribute
    private String number;

    public Engine() {
    }

    public Engine(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "number='" + number + '\''
                + '}';
    }
}
