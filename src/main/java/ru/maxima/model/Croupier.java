package ru.maxima.model;

public class Croupier extends Player {

    public Croupier(String name, Long id) {
        super(name, id);
    }

    @Override
    public String getName() {
        return "croupier";
    }
}
