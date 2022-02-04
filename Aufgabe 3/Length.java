// Length.java
public final class Length extends LengthCalculator {
    
    private final String value;

    public Length(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
