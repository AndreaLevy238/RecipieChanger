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

    public void convertIngredient(ConversionFactor conversionFactor)
    {
        if (conversionFactor.rightUnit(unit))
        {
            amount = amount * conversionFactor.getMultiplier();
            unit = conversionFactor.getTo();
        }
    }
    public void standardizeUnit()
    {
        //this standardizes ways of writing units in terms of volume
        unit = unit.toLowerCase();
        switch(unit)
        {
            case("milliliter"):
                unit = "ml";
                break;
            case("l"):
                unit = "liter";
                break;
            case("tablespoon"):
                unit = "tbsp";
                break;
            case("teaspoon"):
                unit = "tsp";
                break;
            case("pt"):
                unit = "pint";
                break;
            case ("qt"):
                unit = "quart";
                break;
            case("ounce"):
                unit = "oz";
                break;
        }

    }

    public boolean equals(Object obj)
    {
        return obj instanceof Ingredient && ((Ingredient) obj).getItem().equals(item) && ((Ingredient) obj).getUnit().equals(unit)&& ((Ingredient) obj).getAmount()== amount;
    }

}
