package com.rayjackson.ood.composite;

public interface Building {
    <T extends Building> T add(String name);
    void wreck(String name);
}
