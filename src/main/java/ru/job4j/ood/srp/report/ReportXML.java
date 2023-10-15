package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportXML implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportXML(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    public static class CalendarAdapterXml extends XmlAdapter<String, Calendar> {
        private static final ThreadLocal<DateFormat> DATE_FORMAT
                = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd:MM:yyyy HH:mm"));

        @Override
        public Calendar unmarshal(String d) throws ParseException {
            Calendar cal = Calendar.getInstance();
            cal.setTime(DATE_FORMAT.get().parse(d));
            return cal;
        }

        @Override
        public String marshal(Calendar d) {
            return DATE_FORMAT.get().format(d.getTime());
        }
    }

    @XmlRootElement(name = "employees")
    public static class Employees {

        private List<Employee> employee;

        public Employees() {
        }

        public Employees(List<Employee> employees) {
            this.employee = employees;
        }

        public List<Employee> getEmployees() {
            return employee;
        }

        public void setEmployees(List<Employee> employees) {
            this.employee = employees;
        }
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = "";
        try {
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(new Employees(store.findBy(em -> true)), writer);
            xml = writer.getBuffer().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xml;
    }
}
