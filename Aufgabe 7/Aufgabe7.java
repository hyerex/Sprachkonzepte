import java.util.LinkedList;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

public final class Aufgabe7 {
    public static void main(String[] args) throws Exception {
        var list = new LinkedList<ClassInfo>();
        list.add(new ClassInfo(Class.forName("java.lang.String")));
        list.add(new ClassInfo(Class.forName("java.util.LinkedList")));
        list.add(new ClassInfo(Class.forName("java.util.Iterator")));
        list.add(new ClassInfo(Class.forName("java.time.Month")));

        ST template = new STGroupFile("aufgabe7.stg").getInstanceOf("aufgabe7");
        template.add("list", list);

        String result = template.render();
        System.out.println(result);

    }
}

final class ClassInfo {
    public final String name;
    public LinkedList<InterfaceInfo> interfaces;

    public ClassInfo(Class<?> c) {
        this.name = c.getName();
        this.interfaces = new LinkedList<>();
        for (var info : c.getInterfaces()) {
            var currentInterface = new InterfaceInfo(info.getName());

            for (var method : info.getMethods()) {
                currentInterface.methods.add(method.getReturnType().getName() + " " + method.getName());
            }
            this.interfaces.add(currentInterface);
        }
    }
}

final class InterfaceInfo {
    public final String name;
    public final LinkedList<String> methods;

    public InterfaceInfo(String name) {
        this.name = name;
        this.methods = new LinkedList<>();
    }
}
