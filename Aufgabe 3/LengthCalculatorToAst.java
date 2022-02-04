import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public final class LengthCalculatorToAst {

    private LengthCalculatorToAst() {}

    public static void main(String[] args) throws Exception {
        LengthCalculatorLexer lexer = new LengthCalculatorLexer(CharStreams.fromStream(System.in));
        LengthCalculatorParser parser = new LengthCalculatorParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.start();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.printf("%d error(s) detected%n", parser.getNumberOfSyntaxErrors());
            System.exit(1);
        }

        LengthCalculator ast = new LengthCalculatorBuilder().build(tree);
        System.out.printf("LengthCalculator.toString() = \"%s\"%n", ast);
    }
    
}
