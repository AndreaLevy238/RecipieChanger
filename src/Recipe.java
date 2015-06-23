import java.util.List;
import java.util.LinkedList;

public class Recipe {
    private List<Ingredient> ingredients;
    private String name;
    public Recipe(List<Ingredient> ingredients, String name)
    {
        this.ingredients = ingredients;
        this.name = name;
    }
    public Recipe multiplyAllAmounts(double multiplier) {
        List<Ingredient> newIngredientList = new LinkedList<>();
        for (Ingredient i : ingredients) {
            double newAmount = i.getAmount() * multiplier;
            newIngredientList.add(new Ingredient(newAmount, i.getUnit(), i.getItem()));
        }
        return new Recipe(newIngredientList, name);
    }

    public List<Ingredient> getIngredients()
    {
        return ingredients;
    }

    public void print()
    {
        System.out.println(name);
        for (Ingredient i: ingredients)
        {
            String amount = Double.toString(i.getAmount());
            System.out.print(amount + i.getUnit() + " " + i.getItem()+"\n");
        }
    }

}
