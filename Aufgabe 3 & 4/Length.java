import org.stringtemplate.v4.compiler.STParser.mapExpr_return;

// Length.java
public final class Length extends LengthCalculator {
    
    public final String value;
    public final double length;
    public final String unit;

    public final class InvalidUnit extends RuntimeException {
        public InvalidUnit() {
            super("The Length is too long");
        }
    }

    public Length(String value) {
        this.value = value;
        var valueArr = this.value.split(" ");
        if (valueArr[0].length() > 12) {
            throw new InvalidUnit();
        }
        this.length = Double.parseDouble(valueArr[0]);
        this.unit = valueArr[1];
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public double unitsInMeter() {
        switch (unit) {
            case "m":
                return this.length;     
            case "km":
                return this.length * 1000;
            case "dm":
                return this.length / 10;
            case "cm":
                return this.length / 100;
            case "ly":
                return this.length * 1.057e-16;
            default:
                break;
        }
        return 0;
    }
}
