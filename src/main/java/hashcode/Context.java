package hashcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Context {
    private int sum;
    private List<Integer> indexesLeft;
    private List<Integer> sizesLeft;
    private Set<Integer> pickedIndexes = new HashSet<>();

    public Context(List<Integer> indexesLeft, List<Integer> sizesLeft) {
        this.indexesLeft = indexesLeft;
        this.sizesLeft = sizesLeft;
    }

    public List<Integer> getIndexesLeft() {
        return indexesLeft;
    }

    public void setIndexesLeft(List<Integer> indexesLeft) {
        this.indexesLeft = indexesLeft;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Set<Integer> getPickedIndexes() {
        return pickedIndexes;
    }

    public void setSizesLeft(List<Integer> sizesLeft) {
        this.sizesLeft = sizesLeft;
    }

    public List<Integer> getSizesLeft() {
        return sizesLeft;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Context{");
        sb.append("sum=").append(sum);
        sb.append(", indexesLeft=").append(indexesLeft);
        sb.append(", sizesLeft=").append(sizesLeft);
        sb.append(", pickedIndexes=").append(pickedIndexes);
        sb.append('}');
        return sb.toString();
    }
}
