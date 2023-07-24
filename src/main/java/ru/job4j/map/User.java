package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>(16);
        Calendar birthday = Calendar.getInstance();
        User user1 = new User("Andrey", 2, birthday);
        User user2 = new User("Andrey", 2, birthday);
        User user3 = user1;
        int hashCode1 = user1.hashCode();
        int hash1 = hashCode1 ^ (hashCode1 >>> 16);
        int bucket1 = hash1 & 15;
        int hashCode2 = user2.hashCode();
        int hash2 = hashCode2 ^ (hashCode2 >>> 16);
        int bucket2 = hash2 & 15;
        int hashCode3 = user3.hashCode();
        int hash3 = hashCode3 ^ (hashCode3 >>> 16);
        int bucket3 = hash3 & 15;
        map.put(user1, new Object());
        map.put(user2, new Object());
        map.put(user3, new Object());
        System.out.printf("user1 - хэшкод: %s, хэш: %s, бакет: %s", hashCode1, hash1, bucket1);
        System.out.println();
        System.out.printf("user2 - хэшкод: %s, хэш: %s, бакет: %s", hashCode2, hash2, bucket2);
        System.out.println();
        System.out.printf("user3 - хэшкод: %s, хэш: %s, бакет: %s", hashCode3, hash3, bucket3);
    }
}
