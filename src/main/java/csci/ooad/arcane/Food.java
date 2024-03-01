package csci.ooad.arcane;

import java.util.Random;

public class Food extends Entity {

    private double healAmount = 1;

    public Food () {};
    public Food (String name) {
        this.name = name;
    }


    public Food (String name, double healAmount) {
        this.name = name;
        this.healAmount = healAmount;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealAmount() {
        return this.healAmount;
    }

    public void setHealAmount(double healAmount) {
        this.healAmount = healAmount;
    }

    public String getInfo() {
        return getName();
    }
}
