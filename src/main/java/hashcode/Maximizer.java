package hashcode;

public class Maximizer {
    public void run(Restrictions restrictions, Sizes sizes, int times) {
        Context lastBest = null;
        for (int i = 0; i < times; i++) {
            System.out.println(i + ". ========");
            Engine engine = new Engine();
            Context current = engine.calculate(restrictions, sizes);
            if (lastBest == null || lastBest.getSum() < current.getSum()) {
                lastBest = current;
            }
        }

        System.out.println("Winner is: " + lastBest);
    }
}
