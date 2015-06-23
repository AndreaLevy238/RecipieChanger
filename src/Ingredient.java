public class Ingredient {
    private double amount;
    private String unit;
    private String item;

    public Ingredient(double amount, String unit, String item) {
        this.amount = amount;
        this.unit = unit;
        this.item = item;
    }

    public double getAmount()
    {
        return amount;
    }

    public String getUnit()
    {
        return unit;
    }

    public String getItem()
    {
        return item;
    }

    public Ingredient convertToMilliliters() {
        String unitName = unit.toLowerCase();
        double newAmount = 0;
        switch (unitName) {
            case "cup": {
                newAmount = 236.588 * amount;
                break;
            }
            case "tsp":case "teaspoon":{
                newAmount = 4.92892 * amount;
                break;
            }
            case "tbsp":case "tablespoon": {
                newAmount = 14.7868 * amount;
                break;
            }
            case "oz": case "ounces":{
                newAmount = 29.5735 * amount;
                break;
            }
            case "quart": {
                newAmount = 946.353 * amount;
                break;
            }
            case "gallon": {
                newAmount = 3785.41 * amount;
                break;
            }
            case "ml":case "milliliter":
            {
                newAmount = amount;
                break;
            }
            case "l":case"liter":
            {
                newAmount = amount * 1000;
                break;
            }
            default:
            {
                System.out.println("You did not enter a measure of volume");
                newAmount = -1.0;
            }
        }
        return new Ingredient(newAmount, "mL", item);
    }
}
