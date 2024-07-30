package com.github.zipcodewilmington;

public class DashaMapOne implements HashMapX {
    private MyNode[] hashArray;
    private long size;

    public DashaMapOne() {
        hashArray = new MyNode[26]; // For lowercase letters 'a' to 'z'
        size = 0;
    }

    private int hashFunction(String key) {
        return key.length() > 0 ? (key.toLowerCase().charAt(0) - 'a') : -1;
    }

    @Override
    public void set(String key, String value) {
        int index = hashFunction(key);
        if (index < 0) return;
        MyNode newNode = new MyNode(key, value);
        if (hashArray[index] == null) {
            hashArray[index] = newNode;
        } else {
            MyNode current = hashArray[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public String delete(String key) {
        int index = hashFunction(key);
        if (index < 0 || hashArray[index] == null) return null;
        MyNode current = hashArray[index];
        MyNode previous = null;
        while (current != null && !current.key.equals(key)) {
            previous = current;
            current = current.next;
        }
        if (current == null) return null;
        if (previous == null) {
            hashArray[index] = current.next;
        } else {
            previous.next = current.next;
        }
        size--;
        return current.value;
    }

    @Override
    public String get(String key) {
        int index = hashFunction(key);
        if (index < 0 || hashArray[index] == null) return null;
        MyNode current = hashArray[index];
        while (current != null && !current.key.equals(key)) {
            current = current.next;
        }
        return current != null ? current.value : null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public long size() {
        return size;
    }

    @Override
    public boolean bucketSize(String key) {
        int index = hashFunction(key);
        if (index < 0 || hashArray[index] == null) return false;
        int count = 0;
        MyNode current = hashArray[index];
        while (current != null) {
            count++;
            current = current.next;
        }
        return count > 0;
    }
}
