package hashcode;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomStrategy {
    private static final int UNDEFINED = -1;
    private Restrictions restrictions;
    private Sizes sizes;

    public RandomStrategy(Restrictions restrictions, Sizes sizes) {
        this.restrictions = restrictions;
        this.sizes = sizes;
    }
    
    public Context search() {
        Context context = new Context(IntStream.range(0, sizes.getSizes().size())
                .boxed()
                .collect(Collectors.toList())
        , onlyUsable(restrictions.getMaxPieces(), sizes.getSizes()));
        return search(context);
    }

    private Context search(Context context) {
        if (context.getPickedIndexes().size() == restrictions.getMaxTypes()) {
            return context;
        }
        int indexIndex = pickRandomIndexIndex(context);
        if (indexIndex == UNDEFINED) {
            return context;
        }

        context.setSizesLeft(onlyUsable(restrictions.getMaxPieces() - context.getSum(), context.getSizesLeft()));

        int index = context.getIndexesLeft().get(indexIndex);
        int size = sizes.getSizes().get(indexIndex);
        context.getPickedIndexes().add(index);
        context.getIndexesLeft().remove(indexIndex);
        context.getSizesLeft().remove(indexIndex);
        context.setSum(context.getSum() + size);
        System.out.println("index=" + index + " " + "size=" + size + "\n" + context);

        if (context.getSum() + size > restrictions.getMaxPieces()) {
            return context;
        }
        
        return search(context);
    }

    private int pickRandomIndexIndex(Context context) {
        if (context.getIndexesLeft().isEmpty()) {
            return UNDEFINED;
        }
        return new Random().nextInt() % context.getIndexesLeft().size();
    }

    private List<Integer> onlyUsable(int maxPieces, List<Integer> list) {
        return list.stream()
                .filter(i -> i <= maxPieces)
                .collect(Collectors.toList());
    }
}
