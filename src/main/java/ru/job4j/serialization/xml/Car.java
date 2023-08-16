package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlAttribute
    private boolean awd;
    @XmlAttribute
    private int seats;
    private Engine engine;
    @XmlElementWrapper(name = "completeness")
    @XmlElement(name = "status")
    private String[] completeness;

    public Car() {
    }

    public Car(boolean awd, int seats, Engine engine, String... completeness) {
        this.awd = awd;
        this.seats = seats;
        this.engine = engine;
        this.completeness = completeness;
    }

    @Override
    public String toString() {
        return "Car{"
                + "awd=" + awd
                + ", seats=" + seats
                + ", engine=" + engine
                + ", completeness=" + Arrays.toString(completeness)
                + '}';
    }
}
