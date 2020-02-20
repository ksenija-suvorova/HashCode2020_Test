package hashcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sizes {
    private List<Integer> sizes;

    public Sizes(List<Integer> sizes) {
        this.sizes = sizes;
    }

    public Sizes(String line) {
//        HashSet<String> sizesString = new HashSet<>(Arrays.asList(line.split(" ")));
//        sizes = sizesString.stream().map(v -> Integer.valueOf(v)).collect(Collectors.toSet());
        ArrayList<String> sizesString = new ArrayList<>(Arrays.asList(line.split(" ")));
        sizes = sizesString.stream().map(v -> Integer.valueOf(v)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sizes{");
        sb.append("sizes=").append(sizes);
        sb.append('}');
        return sb.toString();
    }

    public List<Integer> getSizes() {
        return sizes;
    }
}
