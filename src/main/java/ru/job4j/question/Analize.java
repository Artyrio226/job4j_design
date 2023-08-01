package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int ad = 0;
        int ch = 0;
        Map<Integer, String> tmp = new HashMap<>();
        for (User p: previous) {
            tmp.put(p.getId(), p.getName());
        }
        for (User c: current) {
            String ok = tmp.computeIfPresent(c.getId(), (a, b) -> {
                if (!(b.equals(c.getName()))) {
                    b = "ok";
                }
                return b;
            });
            if (ok == null) {
                ad++;
            } else if ("ok".equals(ok)) {
                ch++;
            }
        }
        int del = previous.size() - (current.size() - ad);
        return new Info(ad, ch, del);
    }

}
