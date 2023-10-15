package ru.job4j.ood.srp.report;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ReportJSONTest {

    @Test
    public void whenJSONGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Anton", now, now, 120);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportJSON(store, parser);
        JsonArray js = new JsonArray();
        List<Employee> list = store.findBy(em -> true);
        for (Employee employee : list) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", employee.getName());
            jsonObject.addProperty("hired", parser.parse(employee.getHired()));
            jsonObject.addProperty("fired", parser.parse(employee.getHired()));
            jsonObject.addProperty("salary", employee.getSalary());

            js.add(jsonObject);
        }
        System.out.println(js);
        assertThat(engine.generate(em -> true)).isEqualTo(js.toString());
    }
}