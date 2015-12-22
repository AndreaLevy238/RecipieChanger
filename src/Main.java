import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class Main
{
    public static String createItemString(String[] array, int start)
    {
        String newString = "";
        for (int i = start; i < array.length; i++)
        {
            newString = newString +" "+ array[i];
        }
        return newString;
    }

    public static List<Ingredient> createIngredientsFromFile(Scanner in)
    {
        List<Ingredient> ingredients = new LinkedList<>();
        while (in.hasNext())
        {
            String[] line = in.nextLine().split(" ");
            try
            {
                double amount = Double.parseDouble(line[0]);

                ingredients.add(new Ingredient(amount, line[1],createItemString(line, 2)));
            }
            catch(IndexOutOfBoundsException e)
            {
                System.out.print("Ingredient is not complete");
            }
        }
        return ingredients;
    }
    public static List<ConversionFactor> createConversionFactorsFromFile(Scanner in)
    {
        List<ConversionFactor> factors = new LinkedList<>();
        while (in.hasNext())
        {
            String[] line = in.nextLine().split(",");
            try
            {
                factors.add(new ConversionFactor(line[0], line[1], Double.parseDouble(line[2])));
            }
            catch(IndexOutOfBoundsException e)
            {
                System.out.print("Conversion factor is not complete");
            }
        }
        return factors;
    }

    public static Recipe caseA(Scanner in, Recipe recipe)
    {
        System.out.print("By how much do you want to change the recipe?" + "\nIf you want to double the recipe, enter 2.\nIf you want to cut the recipe in half, enter 0.5\n");
        String rawAnswer = in.next();
        double numberAnswer = Double.valueOf(rawAnswer);
        return recipe.multiplyAllAmounts(numberAnswer);
    }

    public static ConversionFactor linearSearchToUnit(List<ConversionFactor> cf, String to)
    {
        for (ConversionFactor f: cf)
        {
            if (f.getTo().equals(to))
            {
                return f;
            }
        }
        throw new Error("Unit not found");
    }
    public static void caseB(Scanner in, Recipe recipe)
    {
        try {

            System.out.print("What ingredient do you want to convert the units of?");
            String ingredientName = in.next();
            Ingredient ingredient = recipe.findIngredient(ingredientName);
            String unitFileName = ingredient.getUnit() + ".csv";
            List<ConversionFactor> conversionFactors = createConversionFactorsFromFile(new Scanner(new File(unitFileName)));
            System.out.print("To what unit do you want to convert your ingredient?");
            String unitName = in.next();
            ingredient.convertIngredient(linearSearchToUnit(conversionFactors, unitName));
            recipe.print();
        }
        catch (FileNotFoundException e)
        {
            System.out.print(e.getMessage());
        }
    }

    public static void main(String[] args) {
	// write your code here
        try
        {
            Scanner in = new Scanner(new File(args[0]));
            Scanner userIn = new Scanner(System.in);
            List<Ingredient> ingredients = createIngredientsFromFile(in);
            Recipe myRecipe = new Recipe(ingredients, args[0]);
            System.out.print("What do you want to do with your recipe?" +
                    "\na)\tchange the amount made \nb)\tconvert units of an ingredient\n");
            String answer1 = userIn.next().toLowerCase();
            switch(answer1)
            {
                case "a":
                {
                    myRecipe = caseA(userIn, myRecipe);
                    myRecipe.print();
                    break;
                }
                case "b":
                {
                    myRecipe.standardizeUnits();
                    myRecipe.print();
                    caseB(userIn,myRecipe);
               }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.print(e.getMessage());
        }

    }
}
