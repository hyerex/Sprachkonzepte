// LengthCalculatorBuilder.java

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class LengthCalculatorBuilder extends LengthCalculatorParserBaseListener {
    public final class InvalidUnit extends RuntimeException {
        public InvalidUnit() {
            super("The Operation with light years is only allowed with km!");
        }
    }
    
    public String unit;

    private Stack<LengthCalculator> stack = new Stack<LengthCalculator>();

    public LengthCalculator build(ParseTree tree) {
        new ParseTreeWalker().walk(this, tree);
        if (!this.checkSemantik()) {
            throw new InvalidUnit();
        };
        return this.stack.pop();
    }

    public Boolean checkSemantik() {
        Operation op = (Operation) this.stack.pop();

        List<String> list = getUnits(op);

        this.stack.push(op);
        return !(list.contains("ly") && (list.contains("m") ||  list.contains("dm") || list.contains("cm") || list.contains("mm")));
    }

    public List<String> getUnits(Operation op) {
        List<String> list = new ArrayList<>();
        if(op.left instanceof Operation) {
            list.addAll(this.getUnits((Operation) op.left));

        } else {
            var left = (Length) op.left;
            list.add(left.unit);
        }
        if(op.right instanceof Operation) {
            list.addAll(this.getUnits((Operation) op.right));
        } else {
            var right = (Length) op.right;
            list.add(right.unit);
        }
        return list;
    }
    
    @Override 
    public void enterUnit(LengthCalculatorParser.UnitContext ctx) { 
        this.unit = ctx.Unit().getText();
    }

    @Override
    public void exitExpr(LengthCalculatorParser.ExprContext ctx) {
        if (ctx.getChildCount() == 3) {
            LengthCalculator right = this.stack.pop();
            LengthCalculator left = this.stack.pop();
            String op = ctx.getChild(1).getText();
            this.stack.push(new Operation(left, op, right));
        }
    }

    @Override
    public void exitLength(LengthCalculatorParser.LengthContext ctx) {
        String s = ctx.Length().getText();
        this.stack.push(new Length(s));
    }

}

