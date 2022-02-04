import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.Collectors;

public final class Functional {

    private Functional() {
    }

    private static final int MIN_LENGTH = 20;

    public static void main(String[] args) throws IOException {
        var input = Files.newBufferedReader(Paths.get(args[0]));
        var lines = new LinkedList<String>();

        long start = System.nanoTime();

        readLines(input, lines);
        removeEmptyLines(lines);
        removeShortLines(lines);
        int n = totalLineLengths(lines);
        long stop = System.nanoTime();

        System.out.printf("result = %d (%d microsec)%n", n, (stop - start) / 1000);
    }

    public static void readLines(BufferedReader input, List<String> lines) {
        lines.addAll(input.lines().collect(Collectors.toList()));
    }

    public static void removeEmptyLines(List<String> lines) {
        lines.removeIf(""::equals);
    }

    public static void removeShortLines(List<String> lines) {
        lines.removeIf(l -> l.length() < MIN_LENGTH);
    }

    public static int totalLineLengths(List<String> lines) {
        return lines.stream()
                .map(l -> l.length())
                .reduce(0, Integer::sum);
    }
}
