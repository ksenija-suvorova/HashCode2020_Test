package hashcode;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class MaximizerTest {
    @Test
    public void test() throws IOException {
        File file = new File(App.class.getClassLoader().getResource("input/a_example.in").getFile());

        String content = null;
        try {
            content = FileUtils.readFileToString(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] lines = content.split("\n");

        String[] restrictionValues = lines[0].split(" ");
        Restrictions restrictions = new Restrictions(Integer.valueOf(restrictionValues[0]), Integer.valueOf(restrictionValues[1]));
        System.out.println(restrictions);

        Sizes sizes = new Sizes(lines[1]);
        System.out.println(sizes);

        Maximizer maximizer = new Maximizer();
        maximizer.run(restrictions, sizes, 1000);

    }
}
