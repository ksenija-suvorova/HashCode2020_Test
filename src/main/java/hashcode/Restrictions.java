package hashcode;

public class Restrictions {
    private int maxPieces;
    private int maxTypes;

    public Restrictions(int maxPieces, int maxTypes) {
        this.maxPieces = maxPieces;
        this.maxTypes = maxTypes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Restrictions{");
        sb.append("maxPieces=").append(maxPieces);
        sb.append(", maxTypes=").append(maxTypes);
        sb.append('}');
        return sb.toString();
    }

    public int getMaxPieces() {
        return maxPieces;
    }

    public int getMaxTypes() {
        return maxTypes;
    }
}
