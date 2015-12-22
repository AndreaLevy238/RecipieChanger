import java.util.LinkedList;
import java.util.List;

public class Test {
    // These test cases return whether a function completes a test
    // Test Cases are written for all methods that are not getters

    // testing methods of Conversion Factor class
    public static boolean testRightUnitCorrect(ConversionFactor conversionFactor)
    {
        //Tests whether function identifies itself as correct
        return conversionFactor.rightUnit(conversionFactor.getFrom());
    }
    public static boolean testRightUnitIncorrect(ConversionFactor conversionFactor)
    {
        //Tests if the function will find a false unit
        // jump is assumed to never be a unit because it is not a noun
        return !conversionFactor.rightUnit("jump");
    }
    //testing methods of Ingredients class
    public static boolean testStandardizeUnit(Ingredient ingredient, String standardUnit)
    {
        // tests whether you can have a standardized unit
        ingredient.standardizeUnit();
        return ingredient.getUnit().equals(standardUnit);
    }
    public static boolean testConvertIngredientPass(Ingredient ingredient, ConversionFactor conversionFactor)
    {
        String correctResult = conversionFactor.getTo();
        ingredient.convertIngredient(conversionFactor);
        return ingredient.getUnit().equals(correctResult);
    }
    public static boolean testConvertIngredientFail(Ingredient ingredient, ConversionFactor conversionFactor)
    {
        ingredient.convertIngredient(conversionFactor);
        return !(ingredient.getUnit().equals(conversionFactor.getFrom()));
    }


    // Test Cases for the Recipe Class
    public static boolean testFindIngredient(Ingredient ingredient, Recipe recipe)
    {
        Ingredient ingredientFound = recipe.findIngredient(ingredient.getItem());
        return ingredientFound.equals(ingredient);

    }
    public static boolean testMultiplyAllAmounts(Recipe recipe, double multiplier)
    {
        Recipe result = recipe.multiplyAllAmounts(multiplier);
        
    }

    // Test Case for Equals
    public static boolean testEquals(Object obj1, Object obj2)
    {
        return obj1.equals(obj2);
    }
    public static boolean testNotEquals(Object obj1, Object obj2)
    {
        return !obj1.equals(obj2);
    }

    // This is the format for the general test Cases
    public static int passed = 0;
    public static int testsRan = 0;
    public static void testCase(boolean test)
    {
        testsRan++;
        if (test)
        {
            passed++;
        }
        else
        {
            System.out.println("test case "+ Integer.toString(testsRan) + " failed");
        }
    }
    public static void main(String[] args)
    {

        ConversionFactor cupToPint = new ConversionFactor("cup", "pint", 0.50721);
        ConversionFactor pintToCup = new ConversionFactor("pint", "cup", 1.97157);
        Ingredient milk = new Ingredient(2.0, "cup","milk");
        Ingredient wine = new Ingredient(750.0, "milliliter","wine");
        Ingredient pinotNoir = new Ingredient(750.0, "ml","wine");
        Ingredient dietCoke = new Ingredient(0.5, "L", "diet coke");
        Ingredient bakingSoda = new Ingredient(1.5, "teaspoon", "baking soda");
        Ingredient vanilla = new Ingredient(1.0, "tablespoon", "vanilla");
        Ingredient beer = new Ingredient(1.0, "pt", "beer");
        Ingredient buttermilk = new Ingredient(0.25, "qt","buttermilk");
        Ingredient coffee = new Ingredient(16.0, "ounce", "coffee");
        List<Ingredient> ingredientList = new LinkedList<>();
        ingredientList.add(milk);
        ingredientList.add(wine);
        ingredientList.add(dietCoke);
        ingredientList.add(bakingSoda);
        ingredientList.add(vanilla);
        ingredientList.add(beer);
        ingredientList.add(buttermilk);
        ingredientList.add(coffee);
        Recipe junk = new Recipe(ingredientList, "junk");

        List<Ingredient> doubledIngredientList = new LinkedList<>();
        doubledIngredientList.add(new Ingredient(4.0, "cup", "milk"));
        doubledIngredientList.add(new Ingredient(1500.0, "ml","wine"));
        doubledIngredientList.add(new Ingredient(1.0, "liter", "diet coke"));
        doubledIngredientList.add(new Ingredient(3.0, "tsp", "baking soda"));
        doubledIngredientList.add(new Ingredient(2.0, "tbsp", "vanilla"));
        doubledIngredientList.add(new Ingredient(2.0, "pint", "beer"));
        doubledIngredientList.add(new Ingredient(0.5, "quart", "buttermilk"));
        doubledIngredientList.add(new Ingredient(32.0, "ounce", "coffee"));
        Recipe junkdoubled = new Recipe(doubledIngredientList,"junk doubled");


        long start = System.currentTimeMillis();
        //Test Cases For Conversion Factor
        // Test Case 1
        testCase(testRightUnitCorrect(cupToPint));
        // Test Case 2
        testCase(testRightUnitCorrect(pintToCup));
        // Test Case 3
        testCase(testRightUnitIncorrect(cupToPint));
        //Test Case 4
        testCase(testRightUnitIncorrect(pintToCup));
        // Test Cases for Ingredient
        // Test Case 5
        testCase(testStandardizeUnit(milk, "cup"));
        // Test Case 6
        testCase(testStandardizeUnit(beer, "pint"));
        // Test Case 7
        testCase(testStandardizeUnit(dietCoke,"liter"));
        // Test Case 8
        testCase(testStandardizeUnit(wine, "ml"));
        // Test Case 9
        testCase(testStandardizeUnit(bakingSoda,"tsp"));
        // Test Case 10
        testCase(testStandardizeUnit(vanilla,"tbsp"));
        // Test Case 11
        testCase(testStandardizeUnit(buttermilk, "quart"));
        // Test Case 12
        testCase(testStandardizeUnit(coffee, "oz"));
        // Test Case 13
        testCase(testConvertIngredientPass(milk, cupToPint));
        // Test Case 14
        testCase(testConvertIngredientFail(dietCoke, cupToPint));
        // Test Case 15
        testCase(testEquals(milk, milk));
        // Test Case 16
        testCase(testNotEquals(milk,buttermilk));
        // Test Case 17
        testCase(testEquals(wine, pinotNoir));

        //Testing Recipe class
        // Test Case 18
        testCase(testFindIngredient(milk,junk));
        // Test Case 19
        testCase(testFindIngredient(wine,junk));
        // Test Case 20
        testCase(testFindIngredient(dietCoke, junk));
        // Test Case 21
        testCase(testFindIngredient(bakingSoda, junk));
        // Test Case 22
        testCase(testFindIngredient(vanilla,junk));
        // Test Case 23
        testCase(testFindIngredient(beer, junk));
        // Test Case 24
        testCase(testFindIngredient(buttermilk, junk));
        // Test Case 25
        testCase(testFindIngredient(coffee, junk));
        // Test Case 26
        testCase(testEquals(junk,junk));
        // Test Case 27
        testCase(testNotEquals(junk,junkdoubled));




        long end = System.currentTimeMillis();
        long timeElapsed = end - start;
        System.out.println(Integer.toString(passed)+ " out of " + Integer.toString(testsRan)+" tests passed.");
        System.out.println("Time taken:"+ Long.toString(timeElapsed) +" millisecond(s).");

    }
}
