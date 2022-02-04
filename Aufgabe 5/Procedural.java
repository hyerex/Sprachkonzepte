import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public final class Procedural {
    private Procedural() {
    }

    private static final int MIN_LENGTH = 20;

    public static void main(String[] args) throws IOException {
        var input = Files.newBufferedReader(Paths.get(args[0]));
        var lines = new LinkedList<String>();

        long start = System.nanoTime();

        readLines(input, lines);
        removeEmptyLines(lines);
        removeShortLines(lines); // alle kürzer als MIN_LENGTH
        int n = totalLineLengths(lines);

        long stop = System.nanoTime();

        System.out.printf("result = %d (%d microsec)%n", n, (stop - start) / 1000);
    }

    private static void readLines(BufferedReader input, LinkedList<String> lines) throws IOException {
        String line;
        while ((line = input.readLine()) != null) {
            lines.add(line);
        }
        System.out.println(lines.toString());
        input.close();
    }

    private static void removeEmptyLines(LinkedList<String> lines) {
        for (int i = 0; i < lines.size() - 1; i++) {
            lines.remove("");
        }
    }

    private static void removeShortLines(LinkedList<String> lines) {
        LinkedList<String> tmpList = new LinkedList<>();

        for (String line : lines) {
            if (line.length() < MIN_LENGTH) {
                tmpList.add(line);
            }
        }

        for (String tmpLine : tmpList) {
            lines.remove(tmpLine);
        }
    }

    private static int totalLineLengths(LinkedList<String> lines) {
        int totalLineLengths = 0;
        for (String line : lines) {
            totalLineLengths += line.length();
        }
        return totalLineLengths;
    }
}
