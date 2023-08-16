package ru.job4j.serialization.json;

import java.util.Arrays;

public class Student {
    private final boolean budget;
    private final int age;
    private final Documents documents;
    private final String[] majors;

    public Student(boolean budget, int age, Documents documents, String[] majors) {
        this.budget = budget;
        this.age = age;
        this.documents = documents;
        this.majors = majors;
    }

    public boolean isBudget() {
        return budget;
    }

    public int getAge() {
        return age;
    }

    public Documents getDocuments() {
        return documents;
    }

    public String[] getMajors() {
        return majors;
    }

    @Override
    public String toString() {
        return "Student{"
                + "budget=" + budget
                + ", age=" + age
                + ", documents=" + documents
                + ", majors=" + Arrays.toString(majors)
                + '}';
    }
}
