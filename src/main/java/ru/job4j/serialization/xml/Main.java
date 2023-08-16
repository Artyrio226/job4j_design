package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
        /* Получаем контекст для доступа к АПИ */
        JAXBContext context = JAXBContext.newInstance(Person.class);
        /* Создаем сериализатор */
        Marshaller marshaller = context.createMarshaller();
        /* Указываем, что нам нужно форматирование */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            /* Сериализуем */
            marshaller.marshal(person, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        /* Для десериализации нам нужно создать десериализатор */
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            /* десериализуем */
            Person result = (Person) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

        final Car car = new Car(false, 4, new Engine("529-378803"), "Conditioner", "Automatic box");

        JAXBContext contextCar = JAXBContext.newInstance(Car.class);
        Marshaller marshallerCar = contextCar.createMarshaller();
        marshallerCar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xmlCar = "";
        try (StringWriter writer = new StringWriter()) {
            marshallerCar.marshal(car, writer);
            xmlCar = writer.getBuffer().toString();
            System.out.println(xmlCar);
        }

        Unmarshaller unmarshallerCar = contextCar.createUnmarshaller();
        try (StringReader reader = new StringReader(xmlCar)) {
            Car result = (Car) unmarshallerCar.unmarshal(reader);
            System.out.println(result);
        }
    }
}
