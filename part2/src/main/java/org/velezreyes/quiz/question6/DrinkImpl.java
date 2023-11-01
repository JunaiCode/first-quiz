package org.velezreyes.quiz.question6;

public class DrinkImpl implements Drink {

    private final double price;
    private final String name;

    private final boolean isFizzy;

    public DrinkImpl(String name, boolean isFizzy, double price) {
        this.name = name;
        this.isFizzy = isFizzy;
        this.price = price;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isFizzy() {
        return isFizzy;
    }

    // Getter for price
    @Override
    public double getPrice() {
        return price;
    }
}
