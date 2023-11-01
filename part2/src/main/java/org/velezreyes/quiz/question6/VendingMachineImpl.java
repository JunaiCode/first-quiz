package org.velezreyes.quiz.question6;


import java.util.ArrayList;

public class VendingMachineImpl implements VendingMachine {
  //Singleton Design Pattern

  private final ArrayList<Drink> drinks;
  private static VendingMachine instance;

  private double money;


  public VendingMachineImpl() {
    drinks = new ArrayList<>();
    //Add drinks
    drinks.add(new DrinkImpl("ScottCola", true, 0.75));
    drinks.add(new DrinkImpl("KarenTea", false, 1.00));
    money = 0;
  }
  public static VendingMachine getInstance() {
    if (instance == null) {
      instance = new VendingMachineImpl();
    }
    return instance;
  }
  @Override
  public void insertQuarter() {
    money += 0.25;
  }
  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    Drink drink = null;
    //Find drink
    for (Drink d : drinks) {
      if (d.getName().equals(name)) {
        drink = d;
        break;
      }
    }
    //Check if drink exists
    if (drink == null) {
      throw new UnknownDrinkException();
    }
    //Check if enough money
    if (drink.getPrice() > money) {
      throw new NotEnoughMoneyException();
    }
    //Return drink
    money = money - drink.getPrice();
    return drink;
}

  @Override
  public double getMoney() {
    return money;
  }
}
