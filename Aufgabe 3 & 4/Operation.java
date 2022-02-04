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

    @Override
    public double unitsInMeter() {
        // TODO Auto-generated method stub
        var left = this.left.unitsInMeter();
        var right = this.right.unitsInMeter();

        if (this.op.equals("+")) {
            return left + right;
        }
        return left - right;
    }
}   
