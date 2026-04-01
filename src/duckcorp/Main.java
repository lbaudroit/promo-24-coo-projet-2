package duckcorp;

import duckcorp.duck.*;
import duckcorp.stock.Stock;

import java.util.List;
import java.util.Map;

/**
 * Point d'entrée de l'application DuckCorp™.
 *
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class Main {
    public static void main(String[] args) {
        testStock();
    }

    private static void testStock() {
        testStockCount();
        testStockRemove();
        testStockCountDefective();
        testStockCountByType();
    }

    private static Stock<Duck> buildTestStock() {
        Stock<Duck> duckStock = new Stock<>();
        duckStock.add(new MiniDuck(3));
        duckStock.add(new StandardDuck(70));
        duckStock.add(new MiniDuck(3));
        duckStock.add(new StandardDuck(70));
        duckStock.add(new StandardDuck(70));
        duckStock.add(new LuxuryDuck(70));

        return duckStock;
    }

    private static void testStockCount() {
        Stock<Duck> duckStock = buildTestStock();

        assert duckStock.count(DuckType.STANDARD) == 3;
        assert duckStock.count(DuckType.MINI) == 2;
        assert duckStock.count(DuckType.LUXURY) == 1;
    }

    private static void testStockCountDefective() {
        Stock<Duck> duckStock = buildTestStock();

        assert duckStock.countDefective() == 2;
    }

    private static void testStockRemove() {
        Stock<Duck> duckStock = buildTestStock();

        // Should remove
        List<Duck> removed = duckStock.remove(DuckType.STANDARD, 2);
        assert duckStock.count(DuckType.STANDARD) == 1;

        // Should return removed ducks
        assert removed.size() == 2;

        // Should raise exception if not enough ducks
        boolean hasRaisedException = false;
        try {
            duckStock.remove(DuckType.LUXURY, 2);
            hasRaisedException = true;
        } catch (IllegalStateException _) {
        }
        assert hasRaisedException;
    }


    private static void testStockCountByType() {
        Stock<Duck> duckStock = buildTestStock();
        duckStock.remove(DuckType.LUXURY, 1);

        Map<DuckType, Integer> countedByType = duckStock.countByType();

        assert countedByType.get(DuckType.MINI) == 2;
        assert countedByType.get(DuckType.STANDARD) == 1;
        // should count empty types too
        assert countedByType.get(DuckType.LUXURY) == 0;
}
}
