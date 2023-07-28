package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean rsl = false;
        int hC = key == null ? 0 : Objects.hashCode(key);
        int i = indexFor(hash(hC));
        if (table[i] == null) {
            table[i] = new MapEntry<>(key, value);
            rsl = true;
            modCount++;
            if (++count >= table.length * LOAD_FACTOR) {
                expand();
            }
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        MapEntry<K, V>[] tmp = new MapEntry[table.length * 2];
        Iterator<K> it = iterator();
        while (it.hasNext()) {
            K key = it.next();
            int hC = key == null ? 0 : Objects.hashCode(key);
            int i = hash(hC) & (tmp.length - 1);
            if (tmp[i] == null) {
                tmp[i] = new MapEntry<>(key, get(key));
            }
        }
        table = tmp;
    }

    @Override
    public V get(K key) {
        int hC = key == null ? 0 : Objects.hashCode(key);
        int i = indexFor(hash(hC));
        V rsl = null;
        if (table[i] != null && hash(hC) == hash(Objects.hashCode(table[i].key))
                             && Objects.equals(table[i].key, key)) {
            rsl = table[i].value;
        }
        return rsl;
    }

    @Override
    public boolean remove(K key) {
        int hC = key == null ? 0 : Objects.hashCode(key);
        int i = indexFor(hash(hC));
        boolean rsl = false;
        if (table[i] != null && hash(hC) == hash(Objects.hashCode(table[i].key))
                             && Objects.equals(table[i].key, key)) {
            table[i] = null;
            modCount++;
            count--;
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            final int expectedModCount = modCount;
            int index = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return index < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}