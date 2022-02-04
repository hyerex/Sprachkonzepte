
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public final class LengthCalculatorInterpreter {
    public static void main(String[] args) throws Exception {

        LengthCalculatorLexer lexer = new LengthCalculatorLexer(CharStreams.fromStream(System.in));
        LengthCalculatorParser parser = new LengthCalculatorParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.start();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.printf("%d error(s) detected%n", parser.getNumberOfSyntaxErrors());
            System.exit(1);
        }

        var builder = new LengthCalculatorBuilder();
        Operation result = (Operation) builder.build(tree);
        var resultInM = result.unitsInMeter();
        String unit = builder.unit;
        switch (unit) {
            case "m":
                System.out.println(resultInM + unit);
                break;
            case "km":
                System.out.println(resultInM / 1000 + unit);
                break;
            case "dm":
                System.out.println(resultInM * 10 + unit);
                break;
            case "cm":
                System.out.println(resultInM * 100 + unit);
                break;
            case "ly":
                System.out.println(resultInM / 1.057e-16 + unit);
                break;
            default:
                break;
        }
    }
}