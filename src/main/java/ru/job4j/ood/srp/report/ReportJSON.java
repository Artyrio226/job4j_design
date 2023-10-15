package ru.job4j.ood.srp.report;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportJSON implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportJSON(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        JsonArray js = new JsonArray();
        for (Employee employee : store.findBy(em -> true)) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", employee.getName());
            jsonObject.addProperty("hired", dateTimeParser.parse(employee.getHired()));
            jsonObject.addProperty("fired", dateTimeParser.parse(employee.getHired()));
            jsonObject.addProperty("salary", employee.getSalary());

            js.add(jsonObject);
        }
        return js.toString();
    }
}
