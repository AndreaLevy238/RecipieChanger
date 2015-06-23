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

    public static Recipe caseA(Scanner in, Recipe recipe)
    {
        System.out.print("By how much do you want to change the recipe?" + "\nIf you want to double the recipe, enter 2.\nIf you want to cut the recipe in half, enter 0.5\n");
        String rawAnswer = in.next();
        double numberAnswer = Double.valueOf(rawAnswer);
        return recipe.multiplyAllAmounts(numberAnswer);
    }
    public static void caseB(Scanner in, Recipe recipe)
    {
        System.out.println("Choose an ingredient from the above recipe that you want to convert.");
        String answer = in.next();
        System.out.println(answer);
        for (Ingredient i: recipe.getIngredients())
            if (i.getItem().contains(answer)) {
                i.convertToMilliliters();
                double mL = i.getAmount();
                System.out.println(Double.toString(mL) + "mL of " + i.getItem());
            }
    }

    public static void main(String[] args) {
	// write your code here
    String filename = "meringue";
        try
        {
            Scanner in = new Scanner(new File(filename));
            Scanner userIn = new Scanner(System.in);
            List<Ingredient> ingredients = createIngredientsFromFile(in);
            Recipe myRecipe = new Recipe(ingredients, filename);
            System.out.print("What do you want to do with your recipe?" +
                    "\na)\tchange the amount made \nb)\tconvert an amount to milliliters\n");
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
