package food_factory;

// Factory pattern
class FoodFactory {
    public static Food getFood(String foodType) {
        if (foodType == null) {
            return null;
        }
        if (foodType.equalsIgnoreCase("PIZZA")) {
            return new Pizza();
        } else if (foodType.equalsIgnoreCase("BURGER")) {
            return new Burger();
        } else if (foodType.equalsIgnoreCase("SALAD")) {
            return new Salad();
        }
        return null;
    }
}

// Prototype pattern
abstract class Food implements Cloneable {
    protected String name;
    protected String ingredients;
    protected double price;

    public String getDetails() {
        return "Name: " + name + ", Ingredients: " + ingredients + ", Price: $" + price;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

class Pizza extends Food {
    public Pizza() {
        name = "Pizza";
        ingredients = "Tomato sauce, mozzarella, pepperoni";
        price = 9.99;
    }
}

class Burger extends Food {
    public Burger() {
        name = "Burger";
        ingredients = "Beef patty, lettuce, tomato, onion, cheese";
        price = 5.99;
    }
}

class Salad extends Food {
    public Salad() {
        name = "Salad";
        ingredients = "Lettuce, tomato, cucumber, olive oil";
        price = 4.99;
    }
}

// Builder pattern
class FoodBuilder {
    private Food food;

    public FoodBuilder setFoodType(String foodType) {
        food = FoodFactory.getFood(foodType);
        return this;
    }

    public FoodBuilder addExtra(String extra) {
        food.ingredients += ", " + extra;
        return this;
    }

    public Food build() {
        return food;
    }
}

public class Main {
    public static void main(String[] args) {
        FoodBuilder foodBuilder = new FoodBuilder();
        Food food1 = foodBuilder.setFoodType("PIZZA").build();
        System.out.println(food1.getDetails());
        Food food2 = foodBuilder.setFoodType("BURGER").addExtra("Bacon").build();
        System.out.println(food2.getDetails());
        Food food3 = foodBuilder.setFoodType("SALAD").addExtra("Croutons").build();
        System.out.println(food3.getDetails());

        //Food food4 = foodBuilder.setFoodType("PASTA").build();
        //System.out.println(food4.getDetails());
    }
}
