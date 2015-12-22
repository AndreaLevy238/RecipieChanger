public class ConversionFactor {
    private String from;
    private String to;
    private double multiplier;

    public ConversionFactor(String from, String to, double multiplier) {
        this.from = from;
        this.to = to;
        this.multiplier = multiplier;
    }
    public String getTo() {
        return to;
    }
    public String getFrom()
    {
        return from;
    }
    public boolean rightUnit(String unit)
    {
        return unit.equals(from);
    }
    public double getMultiplier()
    {
        return multiplier;
    }
}
