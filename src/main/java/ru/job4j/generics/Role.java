package ru.job4j.generics;

public class Role extends Base {

    private final String position;

    public Role(String id, String name) {

        super(id);
        this.position = name;
    }

    public String getUsername() {
        return position;
    }
}
