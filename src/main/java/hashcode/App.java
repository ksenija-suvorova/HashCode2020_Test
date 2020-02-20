package hashcode;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main( String[] args ) throws IOException {
        File file = new File(App.class.getClassLoader().getResource("input/a_example.in").getFile());

        String content = FileUtils.readFileToString(file);

        String[] lines = content.split("\n");
    }
}
