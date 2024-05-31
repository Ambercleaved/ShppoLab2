package com.lab2;

public interface PComponent {
    int getId();
    String getType();
    String getManufacturer();
    String getName();
    void accept(ComponentVisitor visitor);
}

