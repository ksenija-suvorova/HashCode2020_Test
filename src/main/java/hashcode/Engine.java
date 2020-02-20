package hashcode;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Engine {
    public void calculate(Restrictions restrictions, Sizes sizes) {
        List<Integer> list = new ArrayList(sizes.getSizes());

        list = cutOffUnusable(restrictions.getMaxPieces(), list);
        Sizes cutOffSizes = new Sizes(list);


        RandomStrategy strategy = new RandomStrategy(restrictions, sizes);

        Context context = strategy.search();
        System.out.println("============Result==============");
        System.out.println("sum=" + context.getSum() + "\n" +  context.getPickedIndexes());
        System.out.println("context=" + context);

        Set<Integer> resultIndexes = new HashSet<>();

        List<Integer> resultList = new ArrayList<>(context.getPickedIndexes());

        outputResult(context.getPickedIndexes().size(), resultList.stream().sorted().collect(Collectors.toList()));
    }

    private List<Integer> cutOffUnusable(int maxPieces, List<Integer> list) {
        return list.stream().filter(i -> i <= maxPieces).collect(Collectors.toList());
    }

    private void outputResult(int typeCount, List<Integer> indexes) {
        String result = "" + typeCount;
        result += "\n";


        String secondRow = indexes.stream().map(Object::toString).collect(Collectors.joining(" "));
        result += secondRow;

        try {
            FileUtils.writeStringToFile(new File("output/1.txt"), result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
