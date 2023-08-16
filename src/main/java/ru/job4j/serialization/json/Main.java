package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact("11-111"),
                new String[] {"Worker", "Married"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        final String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":35,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                        + "}";
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);
        System.out.println();

        final Student student = new Student(false, 20, new Documents("3574 647751", "93-149"),
                new String[] {"Mathematics", "Physics", "Geometry"});

        final Gson gson1 = new GsonBuilder().create();
        final String studentJson = gson1.toJson(student);
        System.out.println(studentJson);

        final Student studentMod = gson1.fromJson(studentJson, Student.class);
        System.out.println(studentMod);
        System.out.println();

        JSONObject jsonDocuments = new JSONObject("{\"passId\":\"3574 647751\", \"contractId\":\"93-149\"}");

        List<String> list = new ArrayList<>();
        list.add("Mathematics");
        list.add("Physics");
        list.add("Geometry");
        JSONArray jsonMajors = new JSONArray(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("budget", student.isBudget());
        jsonObject.put("age", student.getAge());
        jsonObject.put("documents", jsonDocuments);
        jsonObject.put("majors", jsonMajors);

        System.out.println(jsonObject);

        System.out.println(new JSONObject(student));
    }
}