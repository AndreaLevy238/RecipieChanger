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
    public String getName()
    {
        return name;
    }
    public List<Ingredient> getIngredients()
    {
        return ingredients;
    }
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Recipe))
        {
            return false;
        }
        if (!(((Recipe) obj).getName().equals(name)))
        {
            return false;
        }
        for (int i = 0; i < ingredients.size(); i++)
        {
            if (!(ingredients.get(i).equals(((Recipe) obj).getIngredients().get(i))))
            {
                return false;
            }
        }
        return true;
    }


    public Ingredient findIngredient(String item)
    {
        for (Ingredient i: ingredients)
        {
            if (i.getItem().equals(item))
            {
                return i;
            }
        }
        return null;
    }

    public void standardizeUnits()
    {
        ingredients.forEach(Ingredient::standardizeUnit);
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
