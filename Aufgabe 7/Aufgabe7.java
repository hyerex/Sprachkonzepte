// Aufgabe7.java

import org.stringtemplate.v4.STGroupFile;
import org.stringtemplate.v4.ST;

import java.util.Arrays;

public final class Aufgabe7 {
    private Aufgabe7() {
    }

    public static void main(String[] args) throws Exception {
        Class<?>[] classes = new Class<?>[args.length];
        for(int i = 1, k = 0; i < args.length; i++, k++) {
            classes[k] = Class.forName(args[i]);
        }

        ST templ = new STGroupFile(args[0]).getInstanceOf("aufgabe7");
        templ.add("n", classes);
        String result = templ.render();

        System.out.println(result);
    }
}
