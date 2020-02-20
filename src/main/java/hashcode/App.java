package hashcode;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        File file = new File(App.class.getClassLoader().getResource("input/a_example.in").getFile());

        String content = FileUtils.readFileToString(file);

        String[] lines = content.split("\n");

        String[] restrictionValues = lines[0].split(" ");
        Restrictions restrictions = new Restrictions(Integer.valueOf(restrictionValues[0]), Integer.valueOf(restrictionValues[1]));
        System.out.println(restrictions);

        Sizes sizes = new Sizes(lines[1]);
        System.out.println(sizes);

        Engine engine = new Engine();
        engine.calculate(restrictions, sizes);
    }
}
