// Operation.java
public class Operation extends LengthCalculator{
    public final LengthCalculator left;
    public final String op;
    public final LengthCalculator right;

    public Operation(LengthCalculator left, String op, LengthCalculator right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public String getOperation() {
        return this.op;
    }

    @Override
    public String toString() {
        return "(" + this.left + this.op + this.right + ")";
    }
}   
