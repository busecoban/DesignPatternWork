abstract class Beverage{
    String description = "Unknown Beverage";
    public String getDescription(){
        return description;
    }
    public abstract double cost();
}

 abstract class CondimentDecorator extends Beverage{
    public abstract String getDescription();
}

class Espresso extends Beverage{
    public Espresso(){
        description = "Espresso";
    }
    public double cost(){
        return 1.99;
    }
}

class HouseBlend extends Beverage{
    public HouseBlend(){
        description = "House Blend Coffee";
    }
    public double cost(){
        return .89;
    }
}

class Mocha extends CondimentDecorator{
    Beverage beverage;
    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }
    public String getDescription(){
        return beverage.getDescription() + ", Mocha";
    }
    public double cost(){
        return .20 + beverage.cost();
    }
}

public class StarBuzzCoffee{
    public static void main(String[] args){
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
} 