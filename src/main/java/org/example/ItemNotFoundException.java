package org.example;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(FullNameAndSubject key) {
        super("Name not found:" + key);
    }
}


