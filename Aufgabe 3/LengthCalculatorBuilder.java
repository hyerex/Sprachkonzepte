// LengthCalculatorBuilder.java

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.util.Stack;

public final class LengthCalculatorBuilder extends LengthCalculatorParserBaseListener {
    private Stack<LengthCalculator> stack = new Stack<LengthCalculator>();

    public LengthCalculator build(ParseTree tree) {
        new ParseTreeWalker().walk(this, tree);
        return this.stack.pop();
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

