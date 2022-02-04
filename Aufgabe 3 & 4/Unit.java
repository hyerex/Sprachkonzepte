public final class Unit extends LengthCalculator{
    private final String unit;

    public Unit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return this.unit;
    }

    @Override
    public String toString() {
        return this.unit;
    }
}
