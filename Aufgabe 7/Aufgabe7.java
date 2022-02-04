// Aufgabe7.java

import org.stringtemplate.v4.STGroupFile;
import org.stringtemplate.v4.ST;

import java.util.Arrays;

public final class Aufgabe7 {
    private Aufgabe7() {
    }

    public static void main(String[] args) throws Exception {

        Class<?>[] classes = new Class<?>[4];
        
        classes[0] = Class.forName("java.lang.String");
        classes[1] = Class.forName("java.util.LinkedList");
        classes[2] = Class.forName("java.util.Iterator");
        classes[3] = Class.forName("java.time.Month");

        ST templ = new STGroupFile(args[0]).getInstanceOf("aufgabe7");
        templ.add("n", classes);
        String result = templ.render();

        System.out.println(result);
    }
}
